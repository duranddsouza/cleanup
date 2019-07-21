package com.marshmallow.test.durand.service;

import com.marshmallow.test.durand.model.Cleanup;
import com.marshmallow.test.durand.model.CleanupResponse;
import com.marshmallow.test.durand.model.Coordinates;
import com.marshmallow.test.durand.util.CleanupUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CleanupServiceImpl  implements CleanupService {

    Logger log = LoggerFactory.getLogger(CleanupServiceImpl.class);

    public CleanupResponse start(Cleanup cleanup) throws IllegalStateException {
        log.info("Starting cleanup service");
        Coordinates currentPosition = cleanup.getStartingPosition();
        Integer oilPatchesCleaned = 0;
        for (int i = 0; i < cleanup.getNavigationInstructions().length(); i ++) {
            char direction = cleanup.getNavigationInstructions().charAt(i);
            currentPosition = CleanupUtil.getNextPosition(currentPosition, direction);
            if (! CleanupUtil.isPositionInsideArea(cleanup.getAreaSize(), currentPosition)) {
                throw new IllegalStateException("Can't move cleaner outside area");
            }
            if (cleanup.getOilPatches().remove(currentPosition)) {
                oilPatchesCleaned = oilPatchesCleaned + 1;
            }
        }
        log.info("Finished cleanup service");
        return  new CleanupResponse(currentPosition, oilPatchesCleaned);
    }
}
