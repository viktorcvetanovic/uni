using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity.Domain;
using Microsoft.EntityFrameworkCore;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Data.Context;

public class AppointmentDbContext : DbContext {
	public AppointmentDbContext(DbContextOptions options) : base(options) {
	}

	public DbSet<User> Users { get; set; }
	public DbSet<Role> Roles { get; set; }
	public DbSet<Appointment> Appointments { get; set; }
	public DbSet<AppointmentSchedule> AppointmentSchedules { get; set; }
	
	protected override void OnModelCreating(ModelBuilder modelBuilder)
	{
		modelBuilder.Entity<UserRole>()
			.HasKey(c => new { c.UserID, c.RoleID });

		modelBuilder.Entity<User>()
			.HasMany(c => c.UserRoles)
			.WithOne(us => us.User)
			.IsRequired()
			.HasForeignKey(c => c.UserID);

		modelBuilder.Entity<Role>()
			.HasMany(c => c.UserRoles)
			.WithOne(rl => rl.Role)
			.IsRequired()
			.HasForeignKey(c => c.RoleID);
	}
}