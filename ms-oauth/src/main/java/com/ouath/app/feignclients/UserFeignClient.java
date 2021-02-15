package com.ouath.app.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ouath.app.dto.UserModel;

@Component
@FeignClient(name = "ms-user", path="/users")
public interface UserFeignClient {
	
	@GetMapping("/findByEmail")
	ResponseEntity<UserModel> findByEmail(@RequestParam String email);
}
