using System.Security.Claims;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Repository;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Controllers;

[ApiController]
[Route("logged-in-user")]
public class LoggedInUserController : ControllerBase {
	private readonly ILogger<LoggedInUserController> logger;
	private readonly UserService userService;
	private readonly IHttpContextAccessor httpContextAccessor;

	public LoggedInUserController(UserService userService,
		IHttpContextAccessor httpContextAccessor,
		ILogger<LoggedInUserController> logger) {
		this.userService = userService;
		this.httpContextAccessor = httpContextAccessor;
		this.logger = logger;
	}
	
	[HttpGet("{identifier}")]
	public IActionResult getEmployee(string identifier) {
		return Ok(userService.GetByUsername(identifier));
	}

}