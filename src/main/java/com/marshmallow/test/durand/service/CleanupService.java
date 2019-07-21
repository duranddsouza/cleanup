package com.marshmallow.test.durand.service;

import com.marshmallow.test.durand.model.Cleanup;
import com.marshmallow.test.durand.model.CleanupResponse;

public interface CleanupService {

    public CleanupResponse start(Cleanup cleanup) throws IllegalStateException;

    }
