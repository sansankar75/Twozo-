package com.example.SaveMySpot.Enum;

import com.example.SaveMySpot.common.HibernateUtil;
import com.example.SaveMySpot.entity.ShowSeat;
import com.example.SaveMySpot.service.ShowService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public enum ShowStatus {
    SCHEDULED,
    CANCELLED,
    COMPLETED,
    RUNNING;

}
