function calculateamt() {
    var price = document.getElementById("price");
    var amount = price.value;
    console.log("unitprice" + amount);
    var qty = document.getElementById("quantity");
    var quanty = qty.value;
    console.log(quanty);
    var discount = document.getElementById("offer");
    var dis = discount.value;
    console.log("discount" + dis);
    let totalAmt = 0;

    if (discount != 0) {
        totalAmt = Math.round((amount * quanty) - (amount * quanty)
                * dis / 100);
        console.log(totalAmt);

        document.getElementById("totalprice").value = totalAmt;
    } else {

        document.getElementById("totalprice").value = totalAmt;

    }
    cartfn();
}

function cartfn() {
    let quant = document.getElementById("quantity").value;
    let totprice = document.getElementById("totalprice").value;
    let cartquant = document.getElementById("cartQuantity");
    let carttot = document.getElementById("cartTotalPrice");
    cartquant.value = quant;
    carttot.value = totprice;

}

function chechQuantity() {

    if (document.getElementById("quantity").value == 0
            || document.getElementById("cartQuanity").value == 0)

    {

        document.getElementById("ErrorMsg").style.visibility = "visible";

        return false;
    }
    return true;
}
function makeHidden() {
    document.getElementById("ErrorMsg").style.visibility = "hidden";
}