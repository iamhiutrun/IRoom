import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.iroom.model.entity.User

@Dao
interface UserDAO {

    @Query("select * from user where id = :id")
    fun findById(id: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)
}