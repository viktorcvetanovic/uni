using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;

[Table("appointment_schedule")]
public class AppointmentSchedule : Auditable
{
    [Key, Column("appointment_schedule_id")] public int Id { set; get; }
    [Column("user_fk")]
    [ForeignKey("User")]
    public int? UserFk { get; set; }

    [ForeignKey("UserFk")]
    public virtual User? User { get; set; }
    [Column("appointment_fk")]
    [ForeignKey("Appointment")]
    public int? AppointmentFk { get; set; }

    [ForeignKey("AppointmentFk")]
    public virtual Appointment? Appointment { get; set; }
    [Column("status")] public string? Status { set; get; }

}