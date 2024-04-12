using System.Runtime.Serialization;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Repository;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Service.Impl;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Controllers;

[ApiController]
[Route("appointment-schedules")]
public class AppointmentScheduleController : ControllerBase {
	private readonly ILogger<AppointmentScheduleController> logger;
	private readonly AppointmentScheduleService appointmentScheduleService;
	private readonly IHttpContextAccessor httpContextAccessor;

	public AppointmentScheduleController(AppointmentScheduleService appointmentScheduleService,
		IHttpContextAccessor httpContextAccessor,
		ILogger<AppointmentScheduleController> logger) {
		this.appointmentScheduleService = appointmentScheduleService;
		this.httpContextAccessor = httpContextAccessor;
		this.logger = logger;
	}

	[HttpGet]
	public IActionResult get() {
		return Ok(appointmentScheduleService.GetAll());
	}
	
	[HttpGet("when-date-has-not-passed", Name = "GetAllWhenDateHasNotPassed")]
	public IActionResult GetAllWhenDateHasNotPassed() {
		return Ok(appointmentScheduleService.GetAllWhenDateHasNotPassed());
	}
	
	[HttpGet("{id}/user", Name = "GetAllAppointmentScheduleByUserId")]
	public IActionResult GetAllByUserId(int id) {
		return Ok(appointmentScheduleService.GetAllByUserId(id));
	}
	
	[HttpGet("appointment-is-null/{userId}", Name = "GetAllByUserIdAndAppointmentDateAndStatusIsNull")]
	public IActionResult GetAllByUserIdAndAppointmentDateAndStatusIsNull(int userId,[FromQuery] DateTime date) {
		return Ok(appointmentScheduleService.GetAllByUserIdAndAppointmentDateAndStatusIsNull(userId, date));
	}
	
	
	[HttpGet("{identifier}")]
	public IActionResult getById(int identifier) {
		return Ok(appointmentScheduleService.GetById(identifier));
	}
	
	[HttpPost]
	public IActionResult save([FromBody] AppointmentSchedule appointmentSchedule) {
		return Ok(appointmentScheduleService.Save(appointmentSchedule));
	}

	[HttpPut]
	public IActionResult update([FromBody] AppointmentSchedule appointmentSchedule) {
		return Ok(appointmentScheduleService.Update(appointmentSchedule));
	}

	[HttpDelete("{id}")]
	public void delete(int id)
	{
		appointmentScheduleService.Delete(id);
	}
}