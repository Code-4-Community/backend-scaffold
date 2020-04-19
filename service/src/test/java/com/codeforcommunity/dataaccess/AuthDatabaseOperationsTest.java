package com.codeforcommunity.dataaccess;

import com.codeforcommunity.auth.Passwords;
import com.codeforcommunity.exceptions.CreateUserException;
import com.codeforcommunity.exceptions.ExpiredTokenException;
import com.codeforcommunity.exceptions.InvalidTokenException;
import com.codeforcommunity.exceptions.UserDoesNotExistException;
import com.codeforcommunity.processor.AuthProcessorImpl;
import com.codeforcommunity.propertiesLoader.PropertiesLoader;
import org.jooq.DSLContext;
import org.jooq.generated.Tables;
import org.jooq.generated.tables.pojos.NoteUser;
import org.jooq.generated.tables.records.NoteUserRecord;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;
import org.jooq.generated.tables.records.VerificationKeysRecord;

import static org.jooq.generated.Tables.NOTE_USER;

/**
 * Encapsulates all the database operations that are required for {@link AuthProcessorImpl}.
 */
public class AuthDatabaseOperationsTest {
    // TODO
}
