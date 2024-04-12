using CS322_PZ_Viktor_Cvetanovic_4421.Data.Entity;

namespace CS322_PZ_Viktor_Cvetanovic_4421.Data.Repository;

public interface UserService
{
    User GetByUsername(string username);
    bool IsPasswordValid(string plain, string hashed);
    User GetById(int id);
    List<User> GetAll();
}