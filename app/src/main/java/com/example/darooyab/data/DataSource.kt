package com.example.darooyab.data

import com.example.darooyab.model.Medicine
import com.example.darooyab.model.Pharmacy

object DataSource {
    fun getMedicines(): List<Medicine> {
        return listOf(
            Medicine(1,"Acetaminophen", "استامینوفن", "325mg","قرص"),
            Medicine(2,"Acetaminophen", "استامینوفن", "500mg","قرص"),
            Medicine(3,"Acetaminophen", "استامینوفن", "کدئين","قرص"),
            Medicine(4,"Acetaminophen", "استامینوفن", "60mL","شربت"),
            Medicine(5,"Acetaminophen", "استامینوفن", "120mL","شربت"),
            Medicine(6,"Acetaminophen", "استامینوفن", "100mg","قطره"),
            Medicine(7,"Acetaminophen", "استامینوفن", "75mg","شیاف"),
            Medicine(8,"Acetaminophen", "استامینوفن", "125mg","شیاف"),
            Medicine(9,"Acetaminophen", "استامینوفن", "325mg","شیاف"),
            Medicine(10,"Ibuprofen", "بروفن", "200mg","قرص"),
            Medicine(11,"Ibuprofen", "بروفن", "400mg","قرص"),
            Medicine(12,"Cefixime", "سفکسیم", "200mg","قرص"),
            Medicine(13,"Cefixime", "سفکسیم", "400mg","قرص"),
            Medicine(14,"Diphenhydramine", "دیفن هیدرامین", "60mL","шربت"),
            Medicine(15,"Expectorant", "اکسپکتورانت", "60mL","шربت"),
            Medicine(16,"Tramadol", "ترامادول", "100mg","قرص"),
            Medicine(17,"Oxycodone", "اکسی کدون", "5mg","قرص"),
            Medicine(18,"Valsartan", "والزارتان", "80mg","قرص"),
            Medicine(19,"Valsartan", "والزارتان", "160mg","قرص"),
            Medicine(20,"Pantoprazole", "پنتوپرازول", "20mg","قرص"),
            Medicine(21,"Pantoprazole", "پنتوپرازول", "40mg","قرص"),
            Medicine(22,"Metformin", "متفورمین", "500mg","قرص"),
            Medicine(23,"Metformin", "متفورمین", "1000mg","قرص"),
            Medicine(24,"Sertraline", "سرترالین", "50mg","قرص"),
            Medicine(25,"Sertraline", "سرترالین", "100mg","قرص")
        )
    }

    fun getPharmacies(): List<Pharmacy> {
        return listOf(
            Pharmacy(1,"سامان","خیابان انقلاب","77886655",mutableListOf(1,3,5,7,9,11,13,15,17,23)),
            Pharmacy(2,"آسمان","بلوار کشاورز","88776655",mutableListOf(2,4,6,8,9,10,12,18,22,24)),
            Pharmacy(3,"ابن سینا","خیابان پیروزی","33445566",mutableListOf(3,5,6,7,9,12,15,18,21,24)),
            Pharmacy(4,"ایران","خیابان فلسطین","11223344",mutableListOf(4,8,12,16,13,20,24)),
            Pharmacy(5,"کیوان","خیابان آفریقا","22334455",mutableListOf(1,5,10,11,12,15,20,25)),
            Pharmacy(6,"نرگس","خیابان ولیعصر","99887766",mutableListOf(2,3,6,7,10,13,14,18,22))
        )
    }
}
