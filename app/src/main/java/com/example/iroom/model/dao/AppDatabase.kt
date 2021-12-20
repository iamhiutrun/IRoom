import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.iroom.model.entity.User
import com.example.iroom.utils.Const

@Database(entities = [User::class], version = Const.DATABASE_VERSION)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDAO

}