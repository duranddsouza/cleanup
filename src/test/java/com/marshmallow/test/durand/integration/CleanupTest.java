package com.marshmallow.test.durand.integration;

import com.marshmallow.test.durand.model.CleanupDto;
import com.marshmallow.test.durand.model.CleanupResponseDto;
import com.marshmallow.test.durand.model.Coordinates;
import com.marshmallow.test.durand.model.ErrorDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CleanupTest {

	@LocalServerPort
	private int port;

	private TestRestTemplate testRestTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@Test
	public void valid_test1() {

		// Request
		Integer [] areaSize = {5,5};
		Integer [] startingPosition = {1,2};
		List<Integer[]> oilPatches = new ArrayList<>();
		Integer [] oilPatch1 = {1, 0};
		Integer [] oilPatch2 = {2, 2};
		Integer [] oilPatch3 = {2, 3};

		oilPatches.add(oilPatch1);
		oilPatches.add(oilPatch2);
		oilPatches.add(oilPatch3);

		String navigationInstruction = "NNESEESWNWW";
		CleanupDto dto = new CleanupDto(areaSize, startingPosition, oilPatches, navigationInstruction);


		HttpEntity<CleanupDto> entity = new HttpEntity<>(dto, headers);
		ResponseEntity<CleanupResponseDto> response = testRestTemplate.exchange(createURLWithPort("/cleanup"), HttpMethod.POST, entity, CleanupResponseDto.class);
		Assert.assertTrue(response.getBody().getFinalPosition()[0] == 1);
		Assert.assertTrue(response.getBody().getFinalPosition()[1] == 3);
	}

	@Test
	public void valid_largeArea_test2() {

		// Request
		Integer [] areaSize = {500000000,500000000};
		Integer [] startingPosition = {1,2};
		List<Integer[]> oilPatches = new ArrayList<>();
		Integer [] oilPatch1 = {1, 0};
		Integer [] oilPatch2 = {2, 2};
		Integer [] oilPatch3 = {2, 3};

		oilPatches.add(oilPatch1);
		oilPatches.add(oilPatch2);
		oilPatches.add(oilPatch3);

		String navigationInstruction = "NNESEESWNWW";
		CleanupDto dto = new CleanupDto(areaSize, startingPosition, oilPatches, navigationInstruction);


		HttpEntity<CleanupDto> entity = new HttpEntity<>(dto, headers);
		ResponseEntity<CleanupResponseDto> response = testRestTemplate.exchange(createURLWithPort("/cleanup"), HttpMethod.POST, entity, CleanupResponseDto.class);
		Assert.assertTrue(response.getBody().getOilPatchesCleaned().equals(1));
		Assert.assertTrue(response.getBody().getFinalPosition()[0] == 1);
		Assert.assertTrue(response.getBody().getFinalPosition()[1] == 3);

	}

	@Test
	public void valid_test3() {

		// Request
		Integer [] areaSize = {5,5};
		Integer [] startingPosition = {0,0};
		List<Integer[]> oilPatches = new ArrayList<>();
		Integer [] oilPatch1 = {1, 0};
		Integer [] oilPatch2 = {2, 2};
		Integer [] oilPatch3 = {2, 3};

		oilPatches.add(oilPatch1);
		oilPatches.add(oilPatch2);
		oilPatches.add(oilPatch3);

		String navigationInstruction = "EENNNSEEW";
		CleanupDto dto = new CleanupDto(areaSize, startingPosition, oilPatches, navigationInstruction);


		HttpEntity<CleanupDto> entity = new HttpEntity<>(dto, headers);
		ResponseEntity<CleanupResponseDto> response = testRestTemplate.exchange(createURLWithPort("/cleanup"), HttpMethod.POST, entity, CleanupResponseDto.class);
		Assert.assertTrue(response.getBody().getOilPatchesCleaned().equals(3));
		Assert.assertTrue(response.getBody().getFinalPosition()[0] == 3);
		Assert.assertTrue(response.getBody().getFinalPosition()[1] == 2);

	}


	@Test
	public void invalid_test1() {

		// Request
		Integer [] areaSize = {5,5};
		Integer [] startingPosition = {1,2};
		List<Integer[]> oilPatches = new ArrayList<>();
		Integer [] oilPatch1 = {1, 0};
		Integer [] oilPatch2 = {2, 2};
		Integer [] oilPatch3 = {2, 3};

		oilPatches.add(oilPatch1);
		oilPatches.add(oilPatch2);
		oilPatches.add(oilPatch3);

		String navigationInstruction = "NNNNNNESEESWNWW";
		CleanupDto dto = new CleanupDto(areaSize, startingPosition, oilPatches, navigationInstruction);


		HttpEntity<CleanupDto> entity = new HttpEntity<>(dto, headers);
		ResponseEntity<ErrorDto> response = testRestTemplate.exchange(createURLWithPort("/cleanup"), HttpMethod.POST, entity, ErrorDto.class);
		Assert.assertTrue(response.getStatusCode().value() == 400);
		Assert.assertTrue(response.getBody().getError().contains("Can't move cleaner outside area"));
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
