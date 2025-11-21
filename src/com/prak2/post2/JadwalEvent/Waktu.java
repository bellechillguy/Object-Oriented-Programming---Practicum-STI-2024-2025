//package com.prak2.post2.JadwalEvent;

public class Waktu {
    private int hour;   // 0..23
    private int minute; // 0..59

    // Static attribute untuk default timezone (misalnya "WIB")
    private static String DEFAULT_TZ = "WIB";

    // TODO: default constructor  -> set jam dan menit ke 0
    public Waktu() {
        this.hour = 0;
        this.minute = 0;
    }

    // TODO: Parameterized constructor dengan parameter jam dan menit
    // - batasi jam hanya 0..23
    // - batasi menit hanya 0..59
    public Waktu(int hour, int minute) {
        if (hour < 0) hour = 0;
        if (hour > 23) hour = 23;
        if (minute < 0) minute = 0;
        if (minute > 59) minute = 59;
        this.hour = hour;
        this.minute = minute;
    }

    // TODO: Constructor dengan total menit
    // - ubah total menit jadi jam dan menit
    public Waktu(int totalMinutes) {
        if (totalMinutes < 0) totalMinutes = 0;
        this.hour = (totalMinutes / 60) % 24;
        this.minute = totalMinutes % 60;
    }

    // TODO: Buatlah Getter getHour() dan getMinute()
    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    // ===== STATIC method =====
    // TODO: fromMinutes(int total) -> kembalikan Waktu dari total menit
    public static Waktu fromMinutes(int total) {
        return new Waktu(total);
    }

    // TODO: toMinutes(Waktu t) -> kembalikan total menit dari objek Waktu
    public static int toMinutes(Waktu t) {
        return t.hour * 60 + t.minute;
    }

    // TODO: addMinutes(Waktu t, int add) -> tambah menit ke sebuah Waktu
    public static Waktu addMinutes(Waktu t, int add) {
        int total = toMinutes(t) + add;
        return new Waktu(total);
    }

    // ===== STATIC getter & setter untuk Waktuzone =====
    // TODO: getDefaultTz() -> kembalikan DEFAULT_TZ
    public static String getDefaultTz() {
        return DEFAULT_TZ;
    }

    // TODO: setDefaultTz(String tz) -> ubah DEFAULT_TZ
    public static void setDefaultTz(String tz) {
        if (tz != null) {
            DEFAULT_TZ = tz;
        }
    }

    // Helper untuk format jam:menit
    private String format() {
        return String.format("%02d:%02d", hour, minute);
    }

    @Override
    public String toString() {
        // TODO: kembalikan (bukan print) string "HH:MM TZ", contoh "09:05 WIB"
        return format() + " " + DEFAULT_TZ;
    }
}
