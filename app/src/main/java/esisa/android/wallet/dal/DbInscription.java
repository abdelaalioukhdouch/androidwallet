package esisa.android.wallet.dal;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



import esisa.android.wallet.models.Inscription;

public class DbInscription  extends SQLiteOpenHelper {
    private static final String DB_NAME="INSCRIPTION_DB";
    private static final int DB_VERSION=1;

    private static final String TABLE_INSCRIPTION="inscription";
    private static final String KEY_ID="id";
    private static final String KEY_FULLNAME="fullname";
    private static final String KEY_NUMBER="number";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PASSWORD="password";
    public DbInscription(@android.support.annotation.Nullable Context context, @android.support.annotation.Nullable String name,  @android.support.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table =
                "create table " + TABLE_INSCRIPTION + "("
                        + KEY_ID + " integer primary key autoincrement,"
                        + KEY_FULLNAME + " varchar(30),"
                        +KEY_NUMBER + " varchar(30),"
                        +KEY_EMAIL + " varchar(30),"
                        +KEY_PASSWORD + " varchar(30)"
                        +")";
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_INSCRIPTION);
        onCreate(db);
    }
    public void addInscription(Inscription inscription){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        //values.put(KEY_ID,contact.getId());
        values.put(KEY_FULLNAME,inscription.getFullname());
        values.put(KEY_NUMBER,inscription.getNumber());
        values.put(KEY_EMAIL,inscription.getEmail());
        values.put(KEY_PASSWORD,inscription.getPassword());
        db.insert(TABLE_INSCRIPTION,null,values);
        Log.e("e","addContact dans dbContact"+values.toString());
    }
    public boolean getInscriptionByEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String select_query = "select * from " + TABLE_INSCRIPTION + " where email =" + email;
        Cursor cursor = db.rawQuery(select_query, null);
        if (cursor.moveToFirst()) {
           return true;
        }
       return  false;
    }
    public boolean Login(String email,String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        String select_query = "select * from " + TABLE_INSCRIPTION + " where email =" + email+ " and password ="+pass;
        Cursor cursor = db.rawQuery(select_query, null);
        if (cursor.moveToFirst()) {
            return true;
        }
        return  false;
    }
}

