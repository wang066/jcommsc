package cn.jcomm.test.basicjava.serializable;// Mutable period attack - Page 303

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class MutablePeriodTest {
    // A period instance
    public final PeriodTest period;

    // period's start field, to which we shouldn't have access
    public final Date start;

    // period's end field, to which we shouldn't have access
    public final Date end;

    public MutablePeriodTest() {
        try {
            ByteArrayOutputStream bos =
                    new ByteArrayOutputStream();
            ObjectOutputStream out =
                    new ObjectOutputStream(bos);

            // Serialize a valid PeriodTest instance
            out.writeObject(new PeriodTest(new Date(), new Date()));

            /*
             * Append rogue "previous object refs" for internal
             * Date fields in PeriodTest. For details, see "Java
             * Object Serialization Specification," Section 6.4.
             */
            byte[] ref = {0x71, 0, 0x7e, 0, 5}; // Ref #5
            bos.write(ref); // The start field
            ref[4] = 4;     // Ref # 4
            bos.write(ref); // The end field

            // Deserialize PeriodTest and "stolen" Date references
            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            period = (PeriodTest) in.readObject();
            start = (Date) in.readObject();
            end = (Date) in.readObject();
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        MutablePeriodTest mp = new MutablePeriodTest();
        PeriodTest p = mp.period;
        Date pEnd = mp.end;

        // Let's turn back the clock

        pEnd.setYear(78);
        System.out.println(p);

        // Bring back the 60s!
        pEnd.setYear(69);
        System.out.println(p);
    }
}