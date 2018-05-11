package manuel.easybudget;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "budget_table";
    private static final String COL1 = "name";
    private static final String COL2 = "username";
    private static final String COL3 = "password";
    private static final String COL4 = "income";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1 +" TEXT, " + COL2 +" TEXT, " + COL3 +" TEXT, " + COL4 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //add data to the table
    public boolean addUser(User newuser) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, newuser.getName());
        contentValues.put(COL2, newuser.getUsername());
        contentValues.put(COL3, newuser.getPassword());

        Log.d(TAG, "addData: Adding " + newuser.getName() + ", " + newuser.getUsername() + ", " + newuser.getPassword() + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //error checking
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}
