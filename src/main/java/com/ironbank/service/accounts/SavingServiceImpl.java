package com.ironbank.service.accounts;

import com.ironbank.model.accounts.*;
import com.ironbank.model.users.AccountHolder;
import com.ironbank.repositories.accounts.SavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class SavingServiceImpl implements SavingService {
    @Autowired
    SavingRepository repository;


    @Override
    public List<Saving> findAll() {
        return repository.findAll();
    }

    @Override
    public Saving findById(long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Saving with id " + id + "not found."));
    }

    @Override
    public List<Saving> findByBalance(Money balance) {
        return repository.findByBalance(balance);
    }

    @Override
    public List<Saving> findBySecretKey(String secretKey) {
        return repository.findBySecretKey(secretKey);
    }

    @Override
    public List<Saving> findByPrimaryOwner(AccountHolder primaryOwner) {
        return repository.findByPrimaryOwner(primaryOwner);
    }

    @Override
    public Saving changeBalance(Long id, StudentChecking balance) {
        Saving Saving = (Saving) findById(id);
        var changedName = Saving;
        changedName.setBalance(balance.getBalance());
        return repository.save(changedName);
    }

    @Override
    public List<Saving> findByStatus(Status status) {
        return repository.findByStatus(status);
    }

    @Override
    public Saving create(Saving Saving) {
        return repository.save(Saving);
    }

    @Override
    public Saving changePrimaryOwner(Long id, Saving primaryOwner) {
        Saving Saving = (Saving) findById(id);
        var changedName = Saving;
        changedName.setPrimaryOwner(primaryOwner.getPrimaryOwner());
        return repository.save(changedName);
    }

    @Override
    public Saving upDateSaving(Long id, Saving saving) {
        return null;
    }

    @Override
    public void delete(long id) {
        Saving SavingDel = new Saving();
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public Saving changeBalance(Long id, Saving balance) {
        Saving Saving = (Saving) findById(id);
        var changedName = Saving;
        changedName.setBalance(balance.getBalance());
        return repository.save(changedName);
    }


    /*public Saving addedInterestRate(Saving savingAccount) {
        //YEARS
        var today = LocalDate.now();
        var firstYear = savingAccount.getCreateDate();
        var difAge = ChronoUnit.YEARS.between(today, firstYear);

        var interestRate = savingAccount.getInterestRate();
        var balance = savingAccount.getBalance();
        var lastAddInterestRate = new Money(balance.getAmount().multiply(interestRate.getAmount()));

        if (difAge == 1) {
          savingAccount.setBalance(lastAddInterestRate);
            return savingAccount;

        } else if (difAge>1) {

            var fechaActual=LocalDate.now();
            var createdDate = savingAccount.getCreateDate();
            var lastSubstraction= savingAccount.getModifyDate();
            var difYears = ChronoUnit.YEARS.between(createdDate, fechaActual);

            var newBalance= new Money(balance.getAmount().multiply(interestRate.getAmount()));
            savingAccount.setModifyDate(fechaActual);*/

            // variables necesarias: fecha_actual, fecha_creacion, fecha_ultima_substraccion, distancia_fechas, balance
            // 1er ano -> comprobar diferencia entre f_c y f_a: d_f > 1 -> balance - interst -> f_u_s = hoy
            // Siguientes anos -> comprobar diferencia entre f_u_s y f_a: d_f > 1 -> balance - interst -> f_u_s = hoy

            // cada vez que pasa 1 año del firstyear, sumar interest rate
            // cada vez que se hace el primer addInterestRate i se sume un año, quitar del balance el interest rate




       /* }
        return null;
    }*/
}


