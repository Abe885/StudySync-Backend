package com.coderscampus.studysync;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigurationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAccessToLandingPageWithoutAuthentication() throws Exception {
        mockMvc.perform(get("/landing"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAccessToAdminPageWithAdminRole() throws Exception {
        mockMvc.perform(get("/admin/dashboard").with(user("admin").roles("ADMIN")))
                .andExpect(status().isOk());
    }

    @Test
    public void testAccessToAdminPageWithUserRole() throws Exception {
        mockMvc.perform(get("/admin/dashboard").with(user("user").roles("USER")))
                .andExpect(status().isForbidden());
    }

    @Test
    public void testAccessToModeratorPageWithAuthority() throws Exception {
        mockMvc.perform(get("/moderator/dashboard").with(user("moderator")
                        .authorities(new SimpleGrantedAuthority("MODERATOR_PRIVILEGES"))))
                .andExpect(status().isOk());
    }

    @Test
    public void testAccessToModeratorPageWithoutAuthority() throws Exception {
        mockMvc.perform(get("/moderator/dashboard").with(user("user").roles("USER")))
                .andExpect(status().isForbidden());
    }
}
