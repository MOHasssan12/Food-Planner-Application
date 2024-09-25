package com.example.foodrecipesapp.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDataBase_Impl extends AppDataBase {
  private volatile MealDAO _mealDAO;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `meals_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `idMeal` TEXT, `strMeal` TEXT, `strCategory` TEXT, `strArea` TEXT, `strInstructions` TEXT, `strMealThumb` TEXT, `strYoutube` TEXT, `strIngredient1` TEXT, `strIngredient2` TEXT, `strIngredient3` TEXT, `strIngredient4` TEXT, `strIngredient5` TEXT, `strIngredient6` TEXT, `strIngredient7` TEXT, `strIngredient8` TEXT, `strIngredient9` TEXT, `strIngredient10` TEXT, `strMeasure1` TEXT, `strMeasure2` TEXT, `strMeasure3` TEXT, `strMeasure4` TEXT, `strMeasure5` TEXT, `strMeasure6` TEXT, `strMeasure7` TEXT, `strMeasure8` TEXT, `strSource` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '22553dbb1193e96a6a2c7228db228e50')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `meals_table`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsMealsTable = new HashMap<String, TableInfo.Column>(27);
        _columnsMealsTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("idMeal", new TableInfo.Column("idMeal", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strMeal", new TableInfo.Column("strMeal", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strCategory", new TableInfo.Column("strCategory", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strArea", new TableInfo.Column("strArea", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strInstructions", new TableInfo.Column("strInstructions", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strMealThumb", new TableInfo.Column("strMealThumb", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strYoutube", new TableInfo.Column("strYoutube", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strIngredient1", new TableInfo.Column("strIngredient1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strIngredient2", new TableInfo.Column("strIngredient2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strIngredient3", new TableInfo.Column("strIngredient3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strIngredient4", new TableInfo.Column("strIngredient4", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strIngredient5", new TableInfo.Column("strIngredient5", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strIngredient6", new TableInfo.Column("strIngredient6", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strIngredient7", new TableInfo.Column("strIngredient7", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strIngredient8", new TableInfo.Column("strIngredient8", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strIngredient9", new TableInfo.Column("strIngredient9", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strIngredient10", new TableInfo.Column("strIngredient10", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strMeasure1", new TableInfo.Column("strMeasure1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strMeasure2", new TableInfo.Column("strMeasure2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strMeasure3", new TableInfo.Column("strMeasure3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strMeasure4", new TableInfo.Column("strMeasure4", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strMeasure5", new TableInfo.Column("strMeasure5", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strMeasure6", new TableInfo.Column("strMeasure6", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strMeasure7", new TableInfo.Column("strMeasure7", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strMeasure8", new TableInfo.Column("strMeasure8", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealsTable.put("strSource", new TableInfo.Column("strSource", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMealsTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMealsTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMealsTable = new TableInfo("meals_table", _columnsMealsTable, _foreignKeysMealsTable, _indicesMealsTable);
        final TableInfo _existingMealsTable = TableInfo.read(db, "meals_table");
        if (!_infoMealsTable.equals(_existingMealsTable)) {
          return new RoomOpenHelper.ValidationResult(false, "meals_table(com.example.foodrecipesapp.model.Meal).\n"
                  + " Expected:\n" + _infoMealsTable + "\n"
                  + " Found:\n" + _existingMealsTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "22553dbb1193e96a6a2c7228db228e50", "b2ddfa430e8c7b8e3f547d53cb2e03a9");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "meals_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `meals_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MealDAO.class, MealDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public MealDAO getMealDAO() {
    if (_mealDAO != null) {
      return _mealDAO;
    } else {
      synchronized(this) {
        if(_mealDAO == null) {
          _mealDAO = new MealDAO_Impl(this);
        }
        return _mealDAO;
      }
    }
  }
}
