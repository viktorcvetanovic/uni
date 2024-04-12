using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Repository;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Controllers;

[ApiController]
[Route("appointments")]
public class AppointmentController : ControllerBase {
	private readonly ILogger<AppointmentController> logger;
	private readonly AppointmentService appointmentService;
	private readonly IHttpContextAccessor httpContextAccessor;

	public AppointmentController(AppointmentService appointmentService,
		IHttpContextAccessor httpContextAccessor,
		ILogger<AppointmentController> logger) {
		this.appointmentService = appointmentService;
		this.httpContextAccessor = httpContextAccessor;
		this.logger = logger;
	}

	[HttpGet]
	public IActionResult get() {
		return Ok(appointmentService.GetAll());
	}

	[HttpGet("{id}")]
	public IActionResult getById(int id) {
		return Ok(appointmentService.GetById(id));
	}
	
	
	[HttpGet("appointment_schedule")]
	public IActionResult GetAllAppointmentSchedule() {
		return Ok(appointmentService.GetAllAppointmentSchedule());
	}

	[HttpPost]
	public IActionResult save([FromBody] Appointment appointment) {
		return Ok(appointmentService.Save(appointment));
	}

	[HttpPut]
	public IActionResult update([FromBody] Appointment appointment) {
		return Ok(appointmentService.Update(appointment));
	}
	
	[HttpGet("date", Name = "GetAllAppointmentByDate")]
	public IActionResult GetAllAppointmentByDate([FromQuery] DateTime date) {
		return Ok(appointmentService.GetAllByDate(date));
	}

	
	[HttpDelete("{id}")]
	public void delete(int id) {
		appointmentService.Delete(id);
	}
}