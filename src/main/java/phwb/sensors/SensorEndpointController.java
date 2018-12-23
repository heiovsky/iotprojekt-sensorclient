package phwb.sensors;

import com.profesorfalken.jsensors.JSensors;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import phwb.AppPath;

@RestController
public class SensorEndpointController {

    @SuppressWarnings("unchecked")
    @RequestMapping(value = AppPath.SensorsPath, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public synchronized ResponseEntity index() {

        try {
            return new ResponseEntity(JSensors.get.components(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

