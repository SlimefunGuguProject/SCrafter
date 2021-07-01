package cn.zimzaza4.slimefunzt.listeners;

import com.magmaguy.elitemobs.api.EliteMobDeathEvent;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import cn.zimzaza4.slimefunzt.lists.Items;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class EliteMobD implements Listener {

    @EventHandler
    public void MobD(EntityDamageByEntityEvent e){
       if (e.getDamager()instanceof Player){
          Player p = (Player) e.getDamager();

                if(p.getEquipment().getItemInMainHand()!=null&&SlimefunItem.getByItem(p.getEquipment().getItemInMainHand())!=null
                        &&SlimefunItem.getByItem(p.getEquipment().getItemInMainHand()).getId()=="ZIM_SOUL_SWORD")
                    e.getEntity().getLocation().getWorld().spawnParticle(Particle.SOUL, e.getEntity().getLocation(), 1,1);
                }else if(e.getEntity().getName()!=null&&e.getEntity().getName().contains("§4魂")){
               e.setDamage(e.getDamage()/2);
       }
            }
    @EventHandler
    public void EliteMobDeath(EliteMobDeathEvent e) {
       if (e.getEntity() instanceof LivingEntity) {
           if (e.getEliteMobEntity()!=null){


                   int level = e.getEliteMobEntity().getLevel();

        LivingEntity le = (LivingEntity) e.getEntity();
        if (le.getKiller()!=null&&le.getKiller().getPlayer() != null) {
            int number = (int) Math.floor(level / 3);

            if (number > 40) {
                number = 40;
            }
            if (e.getEntity().getName().contains("§4魂")){
                number = (int) Math.floor(number*1.5);
            }
            if(le.getKiller().getPlayer().getEquipment().getItemInMainHand()!=null&&SlimefunItem.getByItem(le.getKiller().getPlayer().getEquipment().getItemInMainHand())!=null&&SlimefunItem.getByItem(le.getKiller().getPlayer().getEquipment().getItemInMainHand()).getId()=="ZIM_SOUL_SWORD"){
                number = (int) Math.floor(number*1.8);
            }


             if (number > 0){

                e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new SlimefunItemStack(Items.EM_dust, number ));


                }
            }}
        }
    }

}
