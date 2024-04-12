using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Repository;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Controllers;

[ApiController]
[Route("users")]
public class UserController : ControllerBase {
	private readonly ILogger<UserController> logger;
	private readonly UserService userService;
	private readonly IHttpContextAccessor httpContextAccessor;

	public UserController(UserService userService,
		IHttpContextAccessor httpContextAccessor,
		ILogger<UserController> logger) {
		this.userService = userService;
		this.httpContextAccessor = httpContextAccessor;
		this.logger = logger;
	}

	[HttpGet]
	public IActionResult get() {
		return Ok(userService.GetAll());
	}

	[HttpGet("{identifier}")]
	public IActionResult getById(string identifier) {
		return Ok(int.TryParse(identifier, out int val)
			? userService.GetById(val)
			: userService.GetByUsername(identifier));
	}

	[Authorize]
	[HttpPut]
	public IActionResult update() {
		logger.LogWarning("PUT /users Not Implemented");
		return StatusCode(503);
	}

	[Authorize]
	[HttpPut("password")]
	public IActionResult changePassword() {
		logger.LogWarning("PUT /users/password Not Implemented");
		return StatusCode(503);
	}

	
	[Authorize]
	[HttpGet("{identifier}/roles")]
	public IActionResult getRolesById(string identifier) {
		return Ok(new List<Role> {new("ROLE_ADMIN"), new("ROLE_USER")});
	}
}