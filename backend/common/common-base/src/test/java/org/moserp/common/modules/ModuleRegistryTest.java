package org.moserp.common.modules;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { ModuleTestConfiguration.class})
public class ModuleRegistryTest {

    public static final String ENVIRONMENT_MOSERP_ORG = "environment.moserp.org";
    @Autowired
    private ModuleRegistry moduleRegistry;

    @Test
    public void testGetBaseUriForResource() throws Exception {
        String usersUri = moduleRegistry.getBaseUriForResource("users").getUri();
        assertEquals("uri", "http://localhost:8080/users", usersUri);
    }

    @Test
    public void testGetBaseUriForModule() throws Exception {
        String uri = moduleRegistry.getBaseUriForModule(ENVIRONMENT_MOSERP_ORG).getUri();
        assertEquals("uri", "http://localhost:8080/", uri);
    }

    @Test
    public void testGetModuleForResource() throws Exception {
        String module = moduleRegistry.getModuleForResource("users");
        assertEquals("module", ENVIRONMENT_MOSERP_ORG, module);
    }

    @Test
    public void testGetSearchUriForResource() throws Exception {
        String uri = moduleRegistry.getSearchUriForResource("users").getUri();
        assertEquals("uri", "http://localhost:8080/users/search", uri);
    }
}