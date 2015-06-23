/**
 * 
 */
/**
 * @author webonise
 *
 */

@TypeDefs(value = {
		@TypeDef(name = "encryptedString", typeClass = EncryptedStringType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") }),
		@TypeDef(name = "encryptedInt", typeClass = EncryptedIntegerAsStringType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") }),
		@TypeDef(name = "encryptedBoolean", typeClass = EncryptedBooleanAsStringType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") }),
		@TypeDef(name = "encryptedDate", typeClass = EncryptedDateAsStringType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") }),
		@TypeDef(name = "encryptedBigInt", typeClass = EncryptedBigIntegerAsStringType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") }),
		@TypeDef(name = "encryptedFloat", typeClass = EncryptedFloatAsStringType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") }),
		@TypeDef(name = "encryptedBigDecimal", typeClass = EncryptedBigDecimalType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") }) })
package model;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jasypt.hibernate4.type.EncryptedBigDecimalType;
import org.jasypt.hibernate4.type.EncryptedBigIntegerAsStringType;
import org.jasypt.hibernate4.type.EncryptedBooleanAsStringType;
import org.jasypt.hibernate4.type.EncryptedDateAsStringType;
import org.jasypt.hibernate4.type.EncryptedFloatAsStringType;
import org.jasypt.hibernate4.type.EncryptedIntegerAsStringType;
import org.jasypt.hibernate4.type.EncryptedStringType;

