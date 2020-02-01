package demo.knowledgepoints.snowflake;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * ѩ���㷨
 */
public class SnowFlake {

    private final static long twepoch = 12888349746579L;
    // ������ʶλ��
    private final static long workerIdBits = 5L;
    // �������ı�ʶλ��
    private final static long datacenterIdBits = 5L;
    // ����������λ��
    private final static long sequenceBits = 12L;
    // ����IDƫ����12λ
    private final static long workerIdShift = sequenceBits;
    // ��������ID����17λ
    private final static long datacenterIdShift = sequenceBits + workerIdBits;
    // ʱ���������22λ
    private final static long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    //sequence���룬ȷ��sequnce���ᳬ������
    private final static long sequenceMask = -1L ^ (-1L << sequenceBits);
    //�ϴ�ʱ���
    private static long lastTimestamp = -1L;
    //����
    private long sequence = 0L;
    //������ID
    private long workerId = 1L;
    private static long workerMask = -1L ^ (-1L << workerIdBits);
    //���̱���
    private long processId = 1L;
    private static long processMask = -1L ^ (-1L << datacenterIdBits);

    private static SnowFlake snowFlake = null;

    static{
        snowFlake = new SnowFlake();
    }
    public static synchronized long nextId(){
        return snowFlake.getNextId();
    }

    private SnowFlake() {
        //��ȡ��������
        this.workerId=this.getMachineNum();
        //��ȡ���̱���
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        this.processId=Long.valueOf(runtimeMXBean.getName().split("@")[0]).longValue();

        //������볬�����ֵ
        this.workerId=workerId & workerMask;
        this.processId=processId & processMask;
    }

    public synchronized long getNextId() {
        //��ȡʱ���
        long timestamp = timeGen();
        //���ʱ���С���ϴ�ʱ����򱨴�
        if (timestamp < lastTimestamp) {
            try {
                throw new Exception("Clock moved backwards.  Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //���ʱ������ϴ�ʱ�����ͬ
        if (lastTimestamp == timestamp) {
            // ��ǰ�����ڣ���+1����sequenceMaskȷ��sequence���ᳬ������
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // ��ǰ�����ڼ������ˣ���ȴ���һ��
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = timestamp;
        // IDƫ������������յ�ID��������ID
        long nextId = ((timestamp - twepoch) << timestampLeftShift) | (processId << datacenterIdShift) | (workerId << workerIdShift) | sequence;
        return nextId;
    }

    /**
     * �ٴλ�ȡʱ���ֱ����ȡ��ʱ��������еĲ�ͬ
     * @param lastTimestamp
     * @return ��һ��ʱ���
     */
    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * ��ȡ��������
     * @return
     */
    private long getMachineNum(){
        long machinePiece;
        StringBuilder sb = new StringBuilder();
        Enumeration<NetworkInterface> e = null;
        try {
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e1) {
            e1.printStackTrace();
        }
        while (e.hasMoreElements()) {
            NetworkInterface ni = e.nextElement();
            sb.append(ni.toString());
        }
        machinePiece = sb.toString().hashCode();
        return machinePiece;
    }

    public static void main(String[] args) {
        new SnowFlake().getNextId();
    }
}
