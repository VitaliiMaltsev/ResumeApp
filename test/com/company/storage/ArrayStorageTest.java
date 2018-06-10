package com.company.storage;

import com.company.model.Contact;
import com.company.model.ContactType;
import com.company.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStorageTest extends AbstractStorageTest{
    {
        storage = new ArrayStorage();
    }
}