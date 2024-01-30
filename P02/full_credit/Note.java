public class Note {
    private Pitch pitch; 
    private int octave;

    public Note() {
        this.pitch = null;
        this.octave = 0;
    }

    public Note(Pitch pitch, int octave){
        this.pitch = pitch;
        if (octave < -5) {
            this.octave = -5;
        }
        else if (octave > 4) {
            this.octave = 4;
        }
        else  {
            this.octave = octave;
        }
    }

    @Override
    public String toString() {
        if (this.pitch == null)
            return " ";
        else 
            return this.pitch + (this.octave != 0 ? String.valueOf(this.octave) : "");
    }
}