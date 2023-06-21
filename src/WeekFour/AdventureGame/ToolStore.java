package WeekFour.AdventureGame;

public  class ToolStore extends NormalLoc{
    private String helmet;
    private int id;
    private int block;
    private int money;
    private int damage;


    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation(){
        System.out.println("----------- Welcome to the Tool Store! -----------");
        boolean showMenu = true;
        while (showMenu){
        System.out.println("You can buy anything you want in here!");
        getPlayer().playerInfo();
        System.out.println("1 - Menu");
        System.out.println("2 - Weapons ");
        System.out.println("3 - Helmet");
        System.out.println("4 - Exit");

        int selectCase = input.nextInt();
        while (selectCase < 1 || selectCase > 4){
            System.out.println("Incorrect value, please enter again : ");
            selectCase = input.nextInt();
        }


        switch (selectCase){
            case 1:
                menu();
                break;
            case 2:
                getWeaponInfo();
                buyWeapon();
                break;
            case 3:
                getArmorInfo();
                buyHelmet();
                break;
            case 4:
                System.out.println("Bye bye see you again!");
                showMenu = false;
                break;
            default:
                System.out.println("Please select a correct number!");
    }
        }
        return true;
    }


    public void getWeaponInfo(){
        System.out.println("****** Weapons ****** ");
        for (Weapons weapon: Weapons.weapons()) {
            System.out.println("< Id: " + weapon.getId() + " -> "+
                    "\t Name: " + weapon.getName() + " -> "+
                    "\t Damage: " + weapon.getDamage() + " -> "+
                    "\t Price: " + weapon.getPrice() + " >");
        }
        System.out.println("< 0 - Go back to the market. >");
    }
    public void getArmorInfo(){
        System.out.println("****** Helmet *******");
        for (Helmet armor: Helmet.helmets()){
            System.out.println("< Id: " + armor.getId() + " -> " +
                    "\t Name: " + armor.getName() + " -> " +
                    "\t Block: " + armor.getBlock() + " -> " +
                    "\t Price: "+ armor.getPrice()+ " >" );
        }
        System.out.println("< 0 - Go back to the market. >");

    }

    public void menu(){
        System.out.println("You want to check the menu ! Let's see what we got!");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("****** Weapons ****** ");
            for (Weapons weapon: Weapons.weapons()) {
                System.out.println("< Id: " + weapon.getId() + " -> "+
                        "\t Name: " + weapon.getName() + " -> "+
                        "\t Damage: " + weapon.getDamage() + " -> "+
                        "\t Price: " + weapon.getPrice() + " >");
            }
            System.out.println("****** Helmet *******");
            for (Helmet armor: Helmet.helmets()){
                System.out.println("< Id: " + armor.getId() + " -> " +
                        "\t Name: " + armor.getName() + " -> " +
                        "\t Block: " + armor.getBlock() + " -> " +
                        "\t Price: "+ armor.getPrice()+ " >" );
            }
            System.out.println("< 0 - Go back to the market. >");
            int getBack = input.nextInt();
            if (getBack != 0){
                getBack= input.nextInt();
            }
            showMenu = false;
        }
    }
    public void buyHelmet(){
        System.out.print("Obviously you need a helmet! : ");

        int selectHelmetId = input.nextInt();
        while(selectHelmetId < 0 || selectHelmetId > Helmet.helmets().length){
            System.out.println("Please select a correct helmet!!");
            selectHelmetId = input.nextInt();
        }
        if (selectHelmetId != 0){
            Helmet selectedArmor = Helmet.getHelmetObjById(selectHelmetId);
            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("You are out of money!!!");
                }else {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("You bought the " + selectedArmor.getName() + " helmet." );
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Remaining Money: " + this.getPlayer().getMoney());
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Previous Helmet: " +   this.getPlayer().getInventory().getHelmet().getName());
                    System.out.println("---------------------------------------------------------");
                    this.getPlayer().getInventory().setHelmet(selectedArmor);
                    System.out.println("Current Helmet: " +   this.getPlayer().getInventory().getHelmet().getName());
                    System.out.println("---------------------------------------------------------");


                }
            }
        }


    }

    public void buyWeapon(){
        System.out.print("Let's get a weapon for you : ");
        int selectGunId = input.nextInt();
        while (selectGunId < 0 || selectGunId > Weapons.weapons().length){
            System.out.println("Please select a correct weapon!");
            selectGunId = input.nextInt();
        }
        if (selectGunId != 0){
            Weapons selectedGun = Weapons.getWeaponObjById(selectGunId);
            if (selectedGun != null){
                if (selectedGun.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("You are out of money!");
                }else {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("You bought the " + selectedGun.getName() + " gun.");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedGun.getPrice());
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Remaining Money: " +  this.getPlayer().getMoney());
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Previous Weapon: " +   this.getPlayer().getInventory().getWeapon().getName());
                    System.out.println("---------------------------------------------------------");
                    this.getPlayer().getInventory().setWeapon(selectedGun);
                    System.out.println("Current Weapon: " +   this.getPlayer().getInventory().getWeapon().getName());
                    System.out.println("---------------------------------------------------------");


                }
            }
        }

    }

}
