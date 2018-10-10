package edu.alex.cookietest;

import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
public class UUIDGenerator implements IUUIDGenerator {
	private final UUID uuid;
	
	UUIDGenerator(){
		this.uuid = UUID.randomUUID();
	}
	
	@Override
	public String getUUID() {
		return this.uuid.toString();
	}
	
}
