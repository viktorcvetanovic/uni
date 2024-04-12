using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity.Domain;

public class UserRole
{
    [Key, Column(Order = 1)]
    public int UserID { get; set; }
    [Key, Column(Order = 2)]
    public int RoleID { get; set; }

    public virtual User User { get; set; }
    public virtual Role Role { get; set; }
}