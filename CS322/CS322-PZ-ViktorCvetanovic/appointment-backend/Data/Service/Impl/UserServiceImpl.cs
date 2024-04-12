using CS322_PZ_Viktor_Cvetanovic_4421.Data.Context;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;
using CS322_PZ_Viktor_Cvetanovic_4421.Data.Repository;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Data.Service.Impl;

public class UserServiceImpl : UserService
{
    private readonly AuditableContext context;


    public UserServiceImpl(AuditableContext context) {
        this.context = context;
    }

    public User GetById(int id) {
        return context.Users.Single(e => e.Id == id);
    }
	
    public User GetByUsername(string username) {
        return context.Users.Single(e => e.Username == username);
    }
	
    public List<User> GetAll() {
        return context.Users.ToList();
    }
	
    public bool IsPasswordValid(string plain, string hashed) {
        return BCrypt.Net.BCrypt.Verify(plain, hashed);
    }
}