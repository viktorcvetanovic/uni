using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity.Domain;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;

[Table("user")]
public class User : Auditable
{
    [Key, Column("user_id")] public int Id { get; set; }

    [Column("first_name")] public string FirstName { get; set; }

    [Column("last_name")] public string LastName { get; set; }

    [Column("username")] public string Username { get; set; }

    [Column("email")] public string Email { get; set; }

    [JsonIgnore] [Column("password")] public string? Password { get; set; }
    
    [Column("display_name")] public string DisplayName { get; set; }
    
    
    public virtual ICollection<UserRole> UserRoles { get; set; }


}