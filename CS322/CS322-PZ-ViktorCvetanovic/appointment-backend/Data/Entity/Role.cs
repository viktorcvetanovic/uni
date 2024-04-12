using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity.Domain;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;

[Table("role")]
public class Role : Auditable
{
    [Key,Column("role_id")]
    public int Id { set; get; }
    private string name;
    [Column("name")]
    public string Name {
        get => name.Replace("ROLE_", "");
        set => name = "ROLE_" + value.Replace("ROLE_", "");
    }

    public Role(string name) {
        this.name = name;
    }
    public virtual ICollection<UserRole> UserRoles { get; set; }


}