package com.coderdot.services;

import com.coderdot.dto.SignupRequest;
import com.coderdot.entities.UserInfo;

public interface AuthService {
    UserInfo createUser(SignupRequest signupRequest);
}
