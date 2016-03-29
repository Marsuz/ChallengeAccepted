package pl.accepted.challenge.controllers;

import challenges.User;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import pl.accepted.challenge.services.UsersService;

import java.util.Arrays;
import java.util.List;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UsersControllerTest {

	@InjectMocks
	private static UsersController usersController = new UsersController();

	@Mock
	private UsersService usersService;

	@BeforeClass
	public static void setUp() {
		RestAssuredMockMvc.standaloneSetup(usersController);
	}

	@Before
	public void beforeMethodSetUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnAllUsers() throws Exception {
		User user = new User("name1", "name1", "surname1", "password1");
		User user1 = new User("name2", "name1", "surname1", "password1");
		User user2 = new User("name2", "name1", "surname1", "password1");
		List<User> listOfUsers = Arrays.asList(user, user1, user2);
		when(usersService.getAllUsers()).thenReturn(listOfUsers);

		List<User> returnedUsers = Arrays.asList(given().when().get("/users/all").as(User[].class));

		assertThat(returnedUsers).hasSize(3).contains(user, user1, user2);
	}

	@Test
	public void shouldReturnOneUser() throws Exception {
		User expectedUser = new User("username", "name", "surname", "password");
		when(usersService.getUserByName("username")).thenReturn(expectedUser);

		User returnedUser = given().when().get("/users/username").as(User.class);

		assertEquals(expectedUser, returnedUser);
	}

	@Test
	public void shouldCreateUser() throws Exception {
		User toBeCreatedUser = new User("username", "name", "surname", "password");

		given().body(toBeCreatedUser).contentType(ContentType.JSON).post("/users/create");

		verify(usersService, atLeastOnce()).create(toBeCreatedUser);
		verify(usersService,atMost(1)).create(toBeCreatedUser);
	}

	@Test
	public void shouldUpdateUser() throws Exception{
		User userToBeUpdated = new User("username", "name", "surname", "password");

		given().body(userToBeUpdated).contentType(ContentType.JSON).post("/users/update");

		verify(usersService,atLeastOnce()).update(userToBeUpdated);
		verify(usersService,atMost(1)).update(userToBeUpdated);
	}

	@Test
	public void shouldDeleteUser() throws Exception {
		User userToBeDeleted = new User("username", "name", "surname", "password");

		given().body(userToBeDeleted).contentType(ContentType.JSON).delete("/users");

		verify(usersService, atLeastOnce()).deleteUser(userToBeDeleted);
		verify(usersService,atMost(1)).deleteUser(userToBeDeleted);
	}
}