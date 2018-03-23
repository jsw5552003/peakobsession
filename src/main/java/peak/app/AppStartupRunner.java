package peak.app;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import peak.app.model.UserHike;
import peak.app.service.UserHikeService;

@Component
public class AppStartupRunner implements ApplicationRunner {
    
	private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);
    
    @Autowired
    UserHikeService hikeService;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("STARTUP: Populating data");
        hikeService.addHike(new UserHike(LocalDate.now(), 11.2, 2700));
        logger.info("STARTUP: Finished Populating data");
        
    }
}
