using System.ComponentModel;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;

public class Auditable
{
    [JsonIgnore]
    [Column("created_date")]
    public DateTime? CreatedDate { get; set; }
    [JsonIgnore]
    [Column("last_modified_by"), DefaultValue("system")]
    public string? LastModifiedBy { get; set; }
    [JsonIgnore]
    [Column("last_modified_date")]
    public DateTime? LastModifiedDate { get; set; }
    [JsonIgnore]
    [Column("record_status")]
    public int? RecordStatus { get; set; }
}