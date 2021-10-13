package classicstun.message.attributes;

import classicstun.message.enums.MessageAttributeType;
import classicstun.message.exception.MessageAttributeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JiangZhenli
 */
public class Password extends MessageAttribute {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    Password() {
        super(MessageAttributeType.PASSWORD);
    }

    private String password;

    @Override
    public byte[] encode() {
        return new byte[0];
    }

    @Override
    public void decode(byte[] attributeData) throws MessageAttributeException {
        if(attributeData.length <= 0 || attributeData.length % 4 != 0) {
            throw new MessageAttributeException("Password Length Error.");
        }

        this.password = new String(attributeData);
        this.setValue(attributeData);
    }
}
