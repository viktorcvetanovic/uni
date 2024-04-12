using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity.Domain;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;
[Table("appointment")]
public class Appointment : Auditable
{
    [Key, Column("appointment_id")] public int? Id { get; set; }
    [Column("start_time")] public TimeSpan? StartTime { get; set; }
    [Column ("end_time")] public TimeSpan? EndTime { get; set; }
    [Column ( "date")]  public DateTime? Date { get; set; }
    [Column ("status")] public string? Status { get; set; }
    
}