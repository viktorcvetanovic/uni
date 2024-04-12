using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Repository;
using CS322_PZ_Viktor_Cvetanovic_4421.Security;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Controllers;

[Authorize]
[ApiController]
public class AccountController : ControllerBase {
	private readonly ILogger<AccountController> logger;
	private readonly UserService userService;
	private readonly JwtAuthManager jwtAuthManager;

	public AccountController(ILogger<AccountController> logger,
		UserService userService, JwtAuthManager jwtAuthManager) {
		this.logger = logger;
		this.jwtAuthManager = jwtAuthManager;
		this.userService = userService;
	}

	[AllowAnonymous]
	[HttpPost("login")]
	public ActionResult Login([FromBody] LoginRequest request) {
		if (!ModelState.IsValid) {
			return BadRequest();
		}


		User user = userService.GetByUsername(request.Username);

		if (!userService.IsPasswordValid(request.Password, user.Password)) {
			Unauthorized();
		}


		// var role = userRepository.GetUserRole(request.UserName);
		var roles = new List<string> {
			"ROLE_USER",
			"ROLE_ADMIN",
		};

		var jwtResult =
			jwtAuthManager.GenerateTokens(user, roles);
		logger.LogInformation(
			$"User [{request.Username}] logged in the system.");
		return Ok(jwtResult);
	}
}

public class LoginRequest {
	public string Username { get; set; }
	public string Password { get; set; }
}