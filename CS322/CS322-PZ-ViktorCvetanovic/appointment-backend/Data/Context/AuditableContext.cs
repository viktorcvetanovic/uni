using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Data.Context;

public class AuditableContext : AppointmentDbContext {

	public AuditableContext(DbContextOptions options) : base(options) {
	}

	public override int SaveChanges() {
		setAuditProperties();
		return base.SaveChanges();
	}

	public override Task<int> SaveChangesAsync(
		CancellationToken cancellationToken = new()) {
		setAuditProperties();
		return base.SaveChangesAsync(cancellationToken);
	}

	private void setAuditProperties() {
		IEnumerable<EntityEntry> entries = ChangeTracker.Entries();
		foreach (EntityEntry? entry in entries) {
			if (entry.Entity is Auditable entity) {
				DateTime now = DateTime.UtcNow;
				// TODO: implement getting logged in user
				const string user = "system";
				switch (entry.State) {
					case EntityState.Modified:
						entity.LastModifiedDate = now;
						entity.LastModifiedBy = user;
						entity.RecordStatus = 1;
						break;
					case EntityState.Added:
						entity.LastModifiedDate = now;
						entity.CreatedDate = now;
						entity.LastModifiedBy = user;
						entity.RecordStatus = 1;
						break;
					case EntityState.Detached:
						break;
					case EntityState.Unchanged:
						break;
					case EntityState.Deleted:
						break;
					default:
						throw new ArgumentOutOfRangeException();
				}
			}
		}
	}
}