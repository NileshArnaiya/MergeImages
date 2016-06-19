package com.tag.photocaptureandgallery;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.MediaColumns;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.takeimage.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class MainActivity extends ActionBarActivity {

    Button btnSelect1;
    Button btnSelect2;
    Button btnSelect3;
    Button btnSelect4;
    final NotificationCompat.Builder notify;

    Button abc;
    private int[] SELECT_FILE = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private ImageView ivImage1;
    private ImageView ivImage2;
    private ImageView ivImage3;
    private ImageView ivImage4;

    public MainActivity() {
        notify = new NotificationCompat.Builder(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSelect1 = (Button) findViewById(R.id.btnSelectPhoto1);

        btnSelect1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                selectImage1();
            }
        });
        btnSelect2 = (Button) findViewById(R.id.btnSelectPhoto2);

        btnSelect2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                selectImage2();
            }
        });
        btnSelect3 = (Button) findViewById(R.id.btnSelectPhoto3);

        btnSelect3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                selectImage3();
            }
        });
        btnSelect4 = (Button) findViewById(R.id.btnSelectPhoto4);

        btnSelect4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                selectImage4();
            }
        });


        abc = (Button) findViewById(R.id.button);


        ivImage1 = (ImageView) findViewById(R.id.ivImage1);
        ivImage2 = (ImageView) findViewById(R.id.ivImage2);
        ivImage3 = (ImageView) findViewById(R.id.ivImage3);
        ivImage4 = (ImageView) findViewById(R.id.ivImage4);


        abc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                mathod();
            }
        });


    }


    private void selectImage1() {
        final CharSequence[] items = {"Take Photo", "Choose from Library",
                "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items,

                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (items[item].equals("Take Photo")) {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, SELECT_FILE[0]);
                        } else if (items[item].equals("Choose from Library")) {
                            Intent intent = new Intent(
                                    Intent.ACTION_PICK,
                                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("image/*");
                            startActivityForResult(
                                    Intent.createChooser(intent, "Select File"),
                                    SELECT_FILE[1]);
                        } else if (items[item].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
        builder.show();
    }

    private void selectImage2() {
        final CharSequence[] items = {"Take Photo", "Choose from Library",
                "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, SELECT_FILE[2]);
                } else if (items[item].equals("Choose from Library")) {
                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(
                            Intent.createChooser(intent, "Select File"),
                            SELECT_FILE[3]);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void selectImage3() {
        final CharSequence[] items = {"Take Photo", "Choose from Library",
                "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, SELECT_FILE[4]);
                } else if (items[item].equals("Choose from Library")) {
                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(
                            Intent.createChooser(intent, "Select File"),
                            SELECT_FILE[5]);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void selectImage4() {
        final CharSequence[] items = {"Take Photo", "Choose from Library",
                "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, SELECT_FILE[6]);
                } else if (items[item].equals("Choose from Library")) {
                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(
                            Intent.createChooser(intent, "Select File"),
                            SELECT_FILE[7]);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == SELECT_FILE[0]) {
            onCaptureImageResult1(data);
        } else if (requestCode == SELECT_FILE[1]) {
            onSelectFromGalleryResult1(data);
        }

        if (resultCode == Activity.RESULT_OK && requestCode == SELECT_FILE[2]) {
            onCaptureImageResult2(data);
        } else if (requestCode == SELECT_FILE[3]) {
            onSelectFromGalleryResult2(data);


        }
        if (resultCode == Activity.RESULT_OK && requestCode == SELECT_FILE[4]) {
            onCaptureImageResult3(data);
        } else if (requestCode == SELECT_FILE[5]) {
            onSelectFromGalleryResult3(data);


        }
        if (resultCode == Activity.RESULT_OK && requestCode == SELECT_FILE[6]) {
            onCaptureImageResult4(data);
        } else if (requestCode == SELECT_FILE[7]) {
            onSelectFromGalleryResult4(data);


        }

    }


    private void onCaptureImageResult1(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        if (thumbnail != null) {
            thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        }

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ivImage1.setImageBitmap(thumbnail);

    }

    private void onCaptureImageResult2(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        if (thumbnail != null) {
            thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        }

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ivImage2.setImageBitmap(thumbnail);

    }

    private void onCaptureImageResult3(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        if (thumbnail != null) {
            thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        }

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ivImage3.setImageBitmap(thumbnail);

    }

    private void onCaptureImageResult4(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        if (thumbnail != null) {
            thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        }

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ivImage4.setImageBitmap(thumbnail);


    }


    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult1(Intent data) {
        Uri selectedImageUri = data.getData();
        String[] projection = {MediaColumns.DATA};
        Cursor cursor = managedQuery(selectedImageUri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaColumns.DATA);
        cursor.moveToFirst();

        String selectedImagePath = cursor.getString(column_index);

        Bitmap bm;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(selectedImagePath, options);
        final int REQUIRED_SIZE = 500;
        int scale = 1;
        while (options.outWidth / scale >= REQUIRED_SIZE
                && options.outHeight / scale / 2 >= REQUIRED_SIZE)
            scale *= 2;
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(selectedImagePath, options);
        ivImage1.setImageBitmap(bm);
        ivImage1.buildDrawingCache();


    }


    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult2(Intent data2) {
        Uri selectedImageUri = data2.getData();
        String[] projection = {MediaColumns.DATA};
        Cursor cursor = managedQuery(selectedImageUri, projection, null, null,
                null);
        int column_index = cursor.getColumnIndexOrThrow(MediaColumns.DATA);
        cursor.moveToFirst();

        String selectedImagePath = cursor.getString(column_index);

        Bitmap bm;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(selectedImagePath, options);
        final int REQUIRED_SIZE = 500;
        int scale = 1;
        while (options.outWidth / scale >= REQUIRED_SIZE
                && options.outHeight / scale / 2 >= REQUIRED_SIZE)
            scale *= 2;
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(selectedImagePath, options);
        ivImage2.setImageBitmap(bm);
        ivImage2.buildDrawingCache();


    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult3(Intent data3) {
        Uri selectedImageUri = data3.getData();
        String[] projection = {MediaColumns.DATA};
        Cursor cursor = managedQuery(selectedImageUri, projection, null, null,
                null);
        int column_index = cursor.getColumnIndexOrThrow(MediaColumns.DATA);
        cursor.moveToFirst();

        String selectedImagePath = cursor.getString(column_index);

        Bitmap bm;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(selectedImagePath, options);
        final int REQUIRED_SIZE = 500;
        int scale = 1;
        while (options.outWidth / scale >= REQUIRED_SIZE
                && options.outHeight / scale / 2 >= REQUIRED_SIZE)
            scale *= 2;
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(selectedImagePath, options);
        ivImage3.setImageBitmap(bm);
        ivImage3.buildDrawingCache();


    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult4(Intent data4) {
        Uri selectedImageUri = data4.getData();
        String[] projection = {MediaColumns.DATA};
        Cursor cursor = managedQuery(selectedImageUri, projection, null, null,
                null);
        int column_index = cursor.getColumnIndexOrThrow(MediaColumns.DATA);
        cursor.moveToFirst();

        String selectedImagePath = cursor.getString(column_index);

        Bitmap bm;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(selectedImagePath, options);
        final int REQUIRED_SIZE = 500;
        int scale = 1;
        while (options.outWidth / scale >= REQUIRED_SIZE
                && options.outHeight / scale / 2 >= REQUIRED_SIZE)
            scale *= 2;
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(selectedImagePath, options);
        ivImage4.setImageBitmap(bm);
        ivImage4.buildDrawingCache();


    }


    private void mathod() {

        Bitmap[] parts = new Bitmap[4];
        ivImage1.buildDrawingCache();
        ivImage2.buildDrawingCache();
        ivImage3.buildDrawingCache();
        ivImage4.buildDrawingCache();
        parts[0] = ivImage1.getDrawingCache();
        parts[1] = ivImage2.getDrawingCache();
        parts[2] = ivImage3.getDrawingCache();
        parts[3] = ivImage4.getDrawingCache();
        Bitmap result = Bitmap.createBitmap(parts[0].getWidth() * 2, parts[0].getHeight() * 2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        for (int i = 0; i < parts.length; i++) {
            canvas.drawBitmap(parts[i], parts[i].getWidth() * (i % 2), parts[i].getHeight() * (i / 2), paint);
        }


        ByteArrayOutputStream bm = new ByteArrayOutputStream();
        result.compress(Bitmap.CompressFormat.JPEG, 100, bm);

        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        i.putExtra("image", bm.toByteArray());
        Toast.makeText(MainActivity.this, "Your Sweet Pictures have been combined", Toast.LENGTH_SHORT).show();
        long futuretime = System.currentTimeMillis() + 1000;
        while (futuretime > System.currentTimeMillis()) {

            synchronized (this) {

                try {


                    wait(500);
                    startActivity(i);




                } catch (Exception e) {


                }


            }


        }




    }



    public static class Main2Activity extends ActionBarActivity {

        ImageView im;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            im = (ImageView) findViewById(R.id.immaji);

            if (getIntent().hasExtra("image")) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("image"), 0, getIntent().getByteArrayExtra("image").length);
                im.setImageBitmap(bitmap);

            }
            Button save = (Button) findViewById(R.id.save);
            Button share = (Button) findViewById(R.id.share);
            share.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Main2Activity.this, "Sharing is banned in India", Toast.LENGTH_SHORT).show();
                }
            });

            save.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bitmap bitmap;
                    NotificationCompat.Builder notify=new NotificationCompat.Builder(Main2Activity.this);
                    notify.setTicker("Image is ready ");
                    notify.setContentText("Click to Create another");
                    notify.setContentTitle("Abdeali has merged your image");
                    notify.setSmallIcon(R.mipmap.ic_launcher);
                    notify.setAutoCancel(true);
                    notify.setWhen(System.currentTimeMillis());
                    Intent inta=new Intent(getApplicationContext(),MainActivity.class);
                    PendingIntent i= PendingIntent.getActivity(getApplicationContext(),0,inta,PendingIntent.FLAG_UPDATE_CURRENT);
                    notify.setContentIntent(i);
                    NotificationManager n1= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    n1.notify(1,notify.build());



























                    bitmap = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("image"), 0, getIntent().getByteArrayExtra("image").length);

                    File myDir=new File("/sdcard/Reaction");
                    myDir.mkdirs();
                    Random generator = new Random();
                    int n = 10000;
                    Toast.makeText(Main2Activity.this, "Saved To Gallery", Toast.LENGTH_SHORT).show();

                    n = generator.nextInt(n);
                    String fname = "InstaImage"+ n +".jpg";
                    File file = new File (myDir, fname);
                    if (file.exists ()) file.delete ();
                    try {
                        FileOutputStream out = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
                        out.flush();
                        out.close();
                        sendBroadcast(new Intent(
                                Intent.ACTION_MEDIA_MOUNTED,
                                Uri.parse("file://" + Environment.getExternalStorageDirectory())));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    MediaScannerConnection.scanFile(Main2Activity.this, new String[]{file.toString()}, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                public void onScanCompleted(String path, Uri uri) {
                                    Log.i("ExternalStorage", "Scanned " + path + ":");
                                    Log.i("ExternalStorage", "-> uri=" + uri);
                                }
                            });


                }
            });
        }
    }
}
