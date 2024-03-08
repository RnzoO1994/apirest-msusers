package com.homework.msusers.service;

import com.homework.msusers.domain.CreateUserRequest;
import com.homework.msusers.domain.CreateUserResponse;
import com.homework.msusers.domain.PhoneUserRequest;
import com.homework.msusers.persistence.PhonePersistence;
import com.homework.msusers.persistence.UserPersistence;
import com.homework.msusers.persistence.entity.Phone;
import com.homework.msusers.persistence.entity.User;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserPersistence userPersistence;

    @Autowired
    private PhonePersistence phonePersistence;

    @Autowired
    private  JwtService jwtService;
    @Value("${validation.regex-email}")
    private String regexStrEmail;

    @Value("${validation.regex-password}")
    private String regexStrPassword;

    private Pattern patternEmail;

    private Pattern patternPassword;

    @PostConstruct
    public void createRegex() {
        patternEmail = Pattern.compile(regexStrEmail);

        patternPassword = Pattern.compile(regexStrPassword);
    }

    public CreateUserResponse create(CreateUserRequest request) throws Exception {

        if (!patternEmail.matcher(request.getEmail()).matches())
            throw new Exception("El email no cumple con el formato requerido" );

        if (!patternPassword.matcher(request.getPassword()).matches())
            throw new Exception("La contraseña no cumple con el formato requerido");


        Boolean ifexist = userPersistence.exists(request.getEmail());

        if (ifexist)
            throw new Exception("El correo ya está registrado");

         String token = jwtService.generateToken(request.getEmail());

        String timestamp = Timestamp.valueOf(LocalDateTime.now()).toString();

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .lastLogin(timestamp)
                .token(token)
                .active(1)
                .created(timestamp)
                .modified(timestamp)
                .build();

        user = userPersistence.save(user);

        List<Phone> phones = createPhoneList(request.getPhones(), user, request);
        phonePersistence.saveAll(phones);

        return CreateUserResponse.builder()
                .id(user.getId())
                .created(user.getCreated())
                .modified(user.getModified())
                .lastLogin(user.getLastLogin())
                .token(user.getToken())
                .isActive(Boolean.parseBoolean(user.getActive().toString()))
                .build();
    }

    private List<Phone> createPhoneList(List<PhoneUserRequest> phoneRequests, User user, CreateUserRequest requestUser) {
        return phoneRequests.stream()
                .map(request -> Phone.builder()
                        .number(request.getNumber())
                        .userId(user.getId())
                        .cityCode(request.getCityCode())
                        .countryCode(request.getCountryCode())
                        .build())
                .collect(Collectors.toList());
    }
}
