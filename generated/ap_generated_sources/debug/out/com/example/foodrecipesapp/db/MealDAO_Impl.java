package com.example.foodrecipesapp.db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.foodrecipesapp.model.Meal;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MealDAO_Impl implements MealDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Meal> __insertionAdapterOfMeal;

  private final EntityDeletionOrUpdateAdapter<Meal> __deletionAdapterOfMeal;

  public MealDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMeal = new EntityInsertionAdapter<Meal>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `meals_table` (`id`,`idMeal`,`strMeal`,`strCategory`,`strArea`,`strInstructions`,`strMealThumb`,`strYoutube`,`strIngredient1`,`strIngredient2`,`strIngredient3`,`strIngredient4`,`strIngredient5`,`strIngredient6`,`strIngredient7`,`strIngredient8`,`strIngredient9`,`strIngredient10`,`strMeasure1`,`strMeasure2`,`strMeasure3`,`strMeasure4`,`strMeasure5`,`strMeasure6`,`strMeasure7`,`strMeasure8`,`strSource`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Meal entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getIdMeal() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getIdMeal());
        }
        if (entity.getStrMeal() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getStrMeal());
        }
        if (entity.getStrCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getStrCategory());
        }
        if (entity.getStrArea() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getStrArea());
        }
        if (entity.getStrInstructions() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getStrInstructions());
        }
        if (entity.getStrMealThumb() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getStrMealThumb());
        }
        if (entity.getStrYoutube() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getStrYoutube());
        }
        if (entity.getStrIngredient1() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getStrIngredient1());
        }
        if (entity.getStrIngredient2() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getStrIngredient2());
        }
        if (entity.getStrIngredient3() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getStrIngredient3());
        }
        if (entity.getStrIngredient4() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getStrIngredient4());
        }
        if (entity.getStrIngredient5() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getStrIngredient5());
        }
        if (entity.getStrIngredient6() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getStrIngredient6());
        }
        if (entity.getStrIngredient7() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getStrIngredient7());
        }
        if (entity.getStrIngredient8() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getStrIngredient8());
        }
        if (entity.getStrIngredient9() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getStrIngredient9());
        }
        if (entity.getStrIngredient10() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getStrIngredient10());
        }
        if (entity.getStrMeasure1() == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, entity.getStrMeasure1());
        }
        if (entity.getStrMeasure2() == null) {
          statement.bindNull(20);
        } else {
          statement.bindString(20, entity.getStrMeasure2());
        }
        if (entity.getStrMeasure3() == null) {
          statement.bindNull(21);
        } else {
          statement.bindString(21, entity.getStrMeasure3());
        }
        if (entity.getStrMeasure4() == null) {
          statement.bindNull(22);
        } else {
          statement.bindString(22, entity.getStrMeasure4());
        }
        if (entity.getStrMeasure5() == null) {
          statement.bindNull(23);
        } else {
          statement.bindString(23, entity.getStrMeasure5());
        }
        if (entity.getStrMeasure6() == null) {
          statement.bindNull(24);
        } else {
          statement.bindString(24, entity.getStrMeasure6());
        }
        if (entity.getStrMeasure7() == null) {
          statement.bindNull(25);
        } else {
          statement.bindString(25, entity.getStrMeasure7());
        }
        if (entity.getStrMeasure8() == null) {
          statement.bindNull(26);
        } else {
          statement.bindString(26, entity.getStrMeasure8());
        }
        if (entity.getStrSource() == null) {
          statement.bindNull(27);
        } else {
          statement.bindString(27, entity.getStrSource());
        }
      }
    };
    this.__deletionAdapterOfMeal = new EntityDeletionOrUpdateAdapter<Meal>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `meals_table` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Meal entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public void insertMeal(final Meal meal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMeal.insert(meal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteMeal(final Meal meal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMeal.handle(meal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Meal>> getPojos() {
    final String _sql = "SELECT * FROM meals_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"meals_table"}, false, new Callable<List<Meal>>() {
      @Override
      @Nullable
      public List<Meal> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfIdMeal = CursorUtil.getColumnIndexOrThrow(_cursor, "idMeal");
          final int _cursorIndexOfStrMeal = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeal");
          final int _cursorIndexOfStrCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "strCategory");
          final int _cursorIndexOfStrArea = CursorUtil.getColumnIndexOrThrow(_cursor, "strArea");
          final int _cursorIndexOfStrInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "strInstructions");
          final int _cursorIndexOfStrMealThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "strMealThumb");
          final int _cursorIndexOfStrYoutube = CursorUtil.getColumnIndexOrThrow(_cursor, "strYoutube");
          final int _cursorIndexOfStrIngredient1 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient1");
          final int _cursorIndexOfStrIngredient2 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient2");
          final int _cursorIndexOfStrIngredient3 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient3");
          final int _cursorIndexOfStrIngredient4 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient4");
          final int _cursorIndexOfStrIngredient5 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient5");
          final int _cursorIndexOfStrIngredient6 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient6");
          final int _cursorIndexOfStrIngredient7 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient7");
          final int _cursorIndexOfStrIngredient8 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient8");
          final int _cursorIndexOfStrIngredient9 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient9");
          final int _cursorIndexOfStrIngredient10 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient10");
          final int _cursorIndexOfStrMeasure1 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure1");
          final int _cursorIndexOfStrMeasure2 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure2");
          final int _cursorIndexOfStrMeasure3 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure3");
          final int _cursorIndexOfStrMeasure4 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure4");
          final int _cursorIndexOfStrMeasure5 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure5");
          final int _cursorIndexOfStrMeasure6 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure6");
          final int _cursorIndexOfStrMeasure7 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure7");
          final int _cursorIndexOfStrMeasure8 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure8");
          final int _cursorIndexOfStrSource = CursorUtil.getColumnIndexOrThrow(_cursor, "strSource");
          final List<Meal> _result = new ArrayList<Meal>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Meal _item;
            final String _tmpIdMeal;
            if (_cursor.isNull(_cursorIndexOfIdMeal)) {
              _tmpIdMeal = null;
            } else {
              _tmpIdMeal = _cursor.getString(_cursorIndexOfIdMeal);
            }
            final String _tmpStrMeal;
            if (_cursor.isNull(_cursorIndexOfStrMeal)) {
              _tmpStrMeal = null;
            } else {
              _tmpStrMeal = _cursor.getString(_cursorIndexOfStrMeal);
            }
            final String _tmpStrCategory;
            if (_cursor.isNull(_cursorIndexOfStrCategory)) {
              _tmpStrCategory = null;
            } else {
              _tmpStrCategory = _cursor.getString(_cursorIndexOfStrCategory);
            }
            final String _tmpStrArea;
            if (_cursor.isNull(_cursorIndexOfStrArea)) {
              _tmpStrArea = null;
            } else {
              _tmpStrArea = _cursor.getString(_cursorIndexOfStrArea);
            }
            final String _tmpStrInstructions;
            if (_cursor.isNull(_cursorIndexOfStrInstructions)) {
              _tmpStrInstructions = null;
            } else {
              _tmpStrInstructions = _cursor.getString(_cursorIndexOfStrInstructions);
            }
            final String _tmpStrMealThumb;
            if (_cursor.isNull(_cursorIndexOfStrMealThumb)) {
              _tmpStrMealThumb = null;
            } else {
              _tmpStrMealThumb = _cursor.getString(_cursorIndexOfStrMealThumb);
            }
            final String _tmpStrYoutube;
            if (_cursor.isNull(_cursorIndexOfStrYoutube)) {
              _tmpStrYoutube = null;
            } else {
              _tmpStrYoutube = _cursor.getString(_cursorIndexOfStrYoutube);
            }
            final String _tmpStrIngredient1;
            if (_cursor.isNull(_cursorIndexOfStrIngredient1)) {
              _tmpStrIngredient1 = null;
            } else {
              _tmpStrIngredient1 = _cursor.getString(_cursorIndexOfStrIngredient1);
            }
            final String _tmpStrIngredient2;
            if (_cursor.isNull(_cursorIndexOfStrIngredient2)) {
              _tmpStrIngredient2 = null;
            } else {
              _tmpStrIngredient2 = _cursor.getString(_cursorIndexOfStrIngredient2);
            }
            final String _tmpStrIngredient3;
            if (_cursor.isNull(_cursorIndexOfStrIngredient3)) {
              _tmpStrIngredient3 = null;
            } else {
              _tmpStrIngredient3 = _cursor.getString(_cursorIndexOfStrIngredient3);
            }
            final String _tmpStrIngredient4;
            if (_cursor.isNull(_cursorIndexOfStrIngredient4)) {
              _tmpStrIngredient4 = null;
            } else {
              _tmpStrIngredient4 = _cursor.getString(_cursorIndexOfStrIngredient4);
            }
            final String _tmpStrIngredient5;
            if (_cursor.isNull(_cursorIndexOfStrIngredient5)) {
              _tmpStrIngredient5 = null;
            } else {
              _tmpStrIngredient5 = _cursor.getString(_cursorIndexOfStrIngredient5);
            }
            final String _tmpStrIngredient6;
            if (_cursor.isNull(_cursorIndexOfStrIngredient6)) {
              _tmpStrIngredient6 = null;
            } else {
              _tmpStrIngredient6 = _cursor.getString(_cursorIndexOfStrIngredient6);
            }
            final String _tmpStrIngredient7;
            if (_cursor.isNull(_cursorIndexOfStrIngredient7)) {
              _tmpStrIngredient7 = null;
            } else {
              _tmpStrIngredient7 = _cursor.getString(_cursorIndexOfStrIngredient7);
            }
            final String _tmpStrIngredient8;
            if (_cursor.isNull(_cursorIndexOfStrIngredient8)) {
              _tmpStrIngredient8 = null;
            } else {
              _tmpStrIngredient8 = _cursor.getString(_cursorIndexOfStrIngredient8);
            }
            final String _tmpStrIngredient9;
            if (_cursor.isNull(_cursorIndexOfStrIngredient9)) {
              _tmpStrIngredient9 = null;
            } else {
              _tmpStrIngredient9 = _cursor.getString(_cursorIndexOfStrIngredient9);
            }
            final String _tmpStrIngredient10;
            if (_cursor.isNull(_cursorIndexOfStrIngredient10)) {
              _tmpStrIngredient10 = null;
            } else {
              _tmpStrIngredient10 = _cursor.getString(_cursorIndexOfStrIngredient10);
            }
            final String _tmpStrMeasure1;
            if (_cursor.isNull(_cursorIndexOfStrMeasure1)) {
              _tmpStrMeasure1 = null;
            } else {
              _tmpStrMeasure1 = _cursor.getString(_cursorIndexOfStrMeasure1);
            }
            final String _tmpStrMeasure2;
            if (_cursor.isNull(_cursorIndexOfStrMeasure2)) {
              _tmpStrMeasure2 = null;
            } else {
              _tmpStrMeasure2 = _cursor.getString(_cursorIndexOfStrMeasure2);
            }
            final String _tmpStrMeasure3;
            if (_cursor.isNull(_cursorIndexOfStrMeasure3)) {
              _tmpStrMeasure3 = null;
            } else {
              _tmpStrMeasure3 = _cursor.getString(_cursorIndexOfStrMeasure3);
            }
            final String _tmpStrMeasure4;
            if (_cursor.isNull(_cursorIndexOfStrMeasure4)) {
              _tmpStrMeasure4 = null;
            } else {
              _tmpStrMeasure4 = _cursor.getString(_cursorIndexOfStrMeasure4);
            }
            final String _tmpStrMeasure5;
            if (_cursor.isNull(_cursorIndexOfStrMeasure5)) {
              _tmpStrMeasure5 = null;
            } else {
              _tmpStrMeasure5 = _cursor.getString(_cursorIndexOfStrMeasure5);
            }
            final String _tmpStrMeasure6;
            if (_cursor.isNull(_cursorIndexOfStrMeasure6)) {
              _tmpStrMeasure6 = null;
            } else {
              _tmpStrMeasure6 = _cursor.getString(_cursorIndexOfStrMeasure6);
            }
            final String _tmpStrMeasure7;
            if (_cursor.isNull(_cursorIndexOfStrMeasure7)) {
              _tmpStrMeasure7 = null;
            } else {
              _tmpStrMeasure7 = _cursor.getString(_cursorIndexOfStrMeasure7);
            }
            final String _tmpStrMeasure8;
            if (_cursor.isNull(_cursorIndexOfStrMeasure8)) {
              _tmpStrMeasure8 = null;
            } else {
              _tmpStrMeasure8 = _cursor.getString(_cursorIndexOfStrMeasure8);
            }
            final String _tmpStrSource;
            if (_cursor.isNull(_cursorIndexOfStrSource)) {
              _tmpStrSource = null;
            } else {
              _tmpStrSource = _cursor.getString(_cursorIndexOfStrSource);
            }
            _item = new Meal(_tmpIdMeal,_tmpStrMeal,_tmpStrCategory,_tmpStrArea,_tmpStrInstructions,_tmpStrMealThumb,_tmpStrYoutube,_tmpStrIngredient1,_tmpStrIngredient2,_tmpStrIngredient3,_tmpStrIngredient4,_tmpStrIngredient5,_tmpStrIngredient6,_tmpStrIngredient7,_tmpStrIngredient8,_tmpStrIngredient9,_tmpStrIngredient10,_tmpStrMeasure1,_tmpStrMeasure2,_tmpStrMeasure3,_tmpStrMeasure4,_tmpStrMeasure5,_tmpStrMeasure6,_tmpStrMeasure7,_tmpStrMeasure8,_tmpStrSource);
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
