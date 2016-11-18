/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_programthree;


/**
 *
 * @author jameswilliams
 */
public class MP3_Player 
{
    
    private int fileSize;
    private int addSong;
    private int removeSong;
    private int freeSpace;
    private int storageCapacity = 128;
    private boolean playingSong;
    private boolean songAdded;
    private boolean songRemoved;
    
    public MP3_Player()
    {
        fileSize = 0;
        addSong = 0;
        removeSong = 0;
        freeSpace = 0;
        storageCapacity = 0;
        playingSong = false;
        songAdded = false;
        songRemoved = false;
        System.out.println("MP3 Player constructor finished.");
    }
    
    public MP3_Player(int s, int a, int r, int f, int c)
    {
        fileSize = s;
        addSong = a;
        removeSong = r;
        freeSpace = f;
        storageCapacity = c;
        playingSong = false;
        songAdded = false;
        songRemoved = false;
        System.out.println("MP3 Player constructor with parameters finished.");
    }
    
    public String toString()
    {
        return "";
    }
    
    public int getFileSize()
    {
        return fileSize;
    }
    
    public int getFreeSpace()
    {
        return freeSpace;
    }
    
    public int getStorageCapacity()
    {
        return storageCapacity;
    }
    
    public boolean getSongPlaying()
    {
        return playingSong;
    }
    
    public boolean getAddSong()
    {
        return songAdded;
    }
    
    public boolean getRemoveSong()
    {
        return songRemoved;
    }
    
    public void addSong()
    {
        
    }
    
    public void PlaySong()
    {
        playingSong = true;
    }

    //void AddSong(Song)
    //void RemoveSong(Song)
    //void PlaySong(int)
    //int FreeSpace()
    //int GetStorageCapacity()
    //MP3_Player(int)
    //string toString()
    
}
