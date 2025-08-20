package com.servi.serviexpress_api.user.infrastructure.adapters.input.rest;

import com.servi.serviexpress_api.user.application.ports.input.UserServicePortIn;
import com.servi.serviexpress_api.user.domain.model.User;
import com.servi.serviexpress_api.user.infrastructure.adapters.input.rest.mapper.UserRestMapper;
import com.servi.serviexpress_api.user.infrastructure.adapters.input.rest.model.request.UserRegisterRequest;
import com.servi.serviexpress_api.user.infrastructure.adapters.input.rest.model.request.UserUpdateRequest;
import com.servi.serviexpress_api.user.infrastructure.adapters.input.rest.model.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://servi-front.netlify.app")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserRestAdapterController {
    private final UserServicePortIn servicePortIn;
    private final UserRestMapper userRestMapper;

    @GetMapping
    public List<UserResponse> findAll() {
        return userRestMapper.toUserResponseList(servicePortIn.findAll());
    }

    @PostMapping
    public  ResponseEntity<UserResponse> save(@Valid @RequestBody UserRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userRestMapper.toUserResponse(servicePortIn.save(userRestMapper.toUser(request))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok(userRestMapper.toUserResponse(servicePortIn.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> completeProfile(@PathVariable String id, @Valid @RequestBody UserUpdateRequest request) {
        User updated = servicePortIn.completeUserProfile(id, userRestMapper.toUser(request));
        return ResponseEntity.ok(userRestMapper.toUserResponse(updated));
    }


}
