package rw.vtb.dolomit.dolomit.dto.model;

import java.util.Date;
import java.util.UUID;

public class DataDolomitDTO {
    private UUID cs_cmv_id;
    private Date cs_cmv_dateCreated;
    private int cs_cmv_zayavleno;
    private int cs_cmv_prinyato;
    private int cs_cmv_pogruzheno;
    private int cs_cmv_plusMinusPrinyato;
    private UUID hp_id;
    private Date hp_dateCreated;
    private int hp_zayavleno;
    private int hp_prinyato;
    private int hp_pogruzheno;
    private int hp_plusMinusPrinyato;
    private UUID pv_id;
    private Date pv_dateCreated;
    private int pv_zayavleno;
    private int pv_prinyato;
    private int pv_pogruzheno;
    private int pv_plusMinusPrinyato;

    private DataDolomitDTO() {
    }

    public UUID getCs_cmv_id() {
        return cs_cmv_id;
    }

    public Date getCs_cmv_dateCreated() {
        return cs_cmv_dateCreated;
    }

    public int getCs_cmv_zayavleno() {
        return cs_cmv_zayavleno;
    }

    public int getCs_cmv_prinyato() {
        return cs_cmv_prinyato;
    }

    public int getCs_cmv_pogruzheno() {
        return cs_cmv_pogruzheno;
    }

    public int getCs_cmv_plusMinusPrinyato() {
        return cs_cmv_plusMinusPrinyato;
    }

    public UUID getHp_id() {
        return hp_id;
    }

    public Date getHp_dateCreated() {
        return hp_dateCreated;
    }

    public int getHp_zayavleno() {
        return hp_zayavleno;
    }

    public int getHp_prinyato() {
        return hp_prinyato;
    }

    public int getHp_pogruzheno() {
        return hp_pogruzheno;
    }

    public int getHp_plusMinusPrinyato() {
        return hp_plusMinusPrinyato;
    }

    public UUID getPv_id() {
        return pv_id;
    }

    public Date getPv_dateCreated() {
        return pv_dateCreated;
    }

    public int getPv_zayavleno() {
        return pv_zayavleno;
    }

    public int getPv_prinyato() {
        return pv_prinyato;
    }

    public int getPv_pogruzheno() {
        return pv_pogruzheno;
    }

    public int getPv_plusMinusPrinyato() {
        return pv_plusMinusPrinyato;
    }

    public static class Builder {
        private UUID cs_cmv_id;
        private Date cs_cmv_dateCreated;
        private int cs_cmv_zayavleno;
        private int cs_cmv_prinyato;
        private int cs_cmv_pogruzheno;
        private int cs_cmv_plusMinusPrinyato;
        private UUID hp_id;
        private Date hp_dateCreated;
        private int hp_zayavleno;
        private int hp_prinyato;
        private int hp_pogruzheno;
        private int hp_plusMinusPrinyato;
        private UUID pv_id;
        private Date pv_dateCreated;
        private int pv_zayavleno;
        private int pv_prinyato;
        private int pv_pogruzheno;
        private int pv_plusMinusPrinyato;

        public Builder cs_cmv_id(UUID cs_cmv_id) {
            this.cs_cmv_id = cs_cmv_id;
            return this;
        }

        public Builder cs_cmv_dateCreated(Date cs_cmv_dateCreated) {
            this.cs_cmv_dateCreated = cs_cmv_dateCreated;
            return this;
        }

        public Builder cs_cmv_zayavleno(int cs_cmv_zayavleno) {
            this.cs_cmv_zayavleno = cs_cmv_zayavleno;
            return this;
        }

        public Builder cs_cmv_prinyato(int cs_cmv_prinyato) {
            this.cs_cmv_prinyato = cs_cmv_prinyato;
            return this;
        }

        public Builder cs_cmv_pogruzheno(int cs_cmv_pogruzheno) {
            this.cs_cmv_pogruzheno = cs_cmv_pogruzheno;
            return this;
        }

        public Builder cs_cmv_plusMinusPrinyato(int cs_cmv_plusMinusPrinyato) {
            this.cs_cmv_plusMinusPrinyato = cs_cmv_plusMinusPrinyato;
            return this;
        }

        public Builder hp_id(UUID hp_id) {
            this.hp_id = hp_id;
            return this;
        }

        public Builder hp_dateCreated(Date hp_dateCreated) {
            this.hp_dateCreated = hp_dateCreated;
            return this;
        }

        public Builder hp_zayavleno(int hp_zayavleno) {
            this.hp_zayavleno = hp_zayavleno;
            return this;
        }

        public Builder hp_prinyato(int hp_prinyato) {
            this.hp_prinyato = hp_prinyato;
            return this;
        }

        public Builder hp_pogruzheno(int hp_pogruzheno) {
            this.hp_pogruzheno = hp_pogruzheno;
            return this;
        }

        public Builder hp_plusMinusPrinyato(int hp_plusMinusPrinyato) {
            this.hp_plusMinusPrinyato = hp_plusMinusPrinyato;
            return this;
        }

        public Builder pv_id(UUID pv_id) {
            this.pv_id = pv_id;
            return this;
        }

        public Builder pv_dateCreated(Date pv_dateCreated) {
            this.pv_dateCreated = pv_dateCreated;
            return this;
        }

        public Builder pv_zayavleno(int pv_zayavleno) {
            this.pv_zayavleno = pv_zayavleno;
            return this;
        }

        public Builder pv_prinyato(int pv_prinyato) {
            this.pv_prinyato = pv_prinyato;
            return this;
        }

        public Builder pv_pogruzheno(int pv_pogruzheno) {
            this.pv_pogruzheno = pv_pogruzheno;
            return this;
        }

        public Builder pv_plusMinusPrinyato(int pv_plusMinusPrinyato) {
            this.pv_plusMinusPrinyato = pv_plusMinusPrinyato;
            return this;
        }

        public DataDolomitDTO build() {
            DataDolomitDTO dataDolomitDTO = new DataDolomitDTO();
            dataDolomitDTO.cs_cmv_id = this.cs_cmv_id;
            dataDolomitDTO.cs_cmv_dateCreated = this.cs_cmv_dateCreated;
            dataDolomitDTO.cs_cmv_zayavleno = this.cs_cmv_zayavleno;
            dataDolomitDTO.cs_cmv_prinyato = this.cs_cmv_prinyato;
            dataDolomitDTO.cs_cmv_pogruzheno = this.cs_cmv_pogruzheno;
            dataDolomitDTO.cs_cmv_plusMinusPrinyato = this.cs_cmv_plusMinusPrinyato;
            dataDolomitDTO.hp_id = this.hp_id;
            dataDolomitDTO.hp_dateCreated = this.hp_dateCreated;
            dataDolomitDTO.hp_zayavleno = this.hp_zayavleno;
            dataDolomitDTO.hp_prinyato = this.hp_prinyato;
            dataDolomitDTO.hp_pogruzheno = this.hp_pogruzheno;
            dataDolomitDTO.hp_plusMinusPrinyato = this.hp_plusMinusPrinyato;
            dataDolomitDTO.pv_id = this.pv_id;
            dataDolomitDTO.pv_dateCreated = this.pv_dateCreated;
            dataDolomitDTO.pv_zayavleno = this.pv_zayavleno;
            dataDolomitDTO.pv_prinyato = this.pv_prinyato;
            dataDolomitDTO.pv_pogruzheno = this.pv_pogruzheno;
            dataDolomitDTO.pv_plusMinusPrinyato = this.pv_plusMinusPrinyato;
            return dataDolomitDTO;
        }
    }
}
