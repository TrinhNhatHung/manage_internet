function deleteItem (event){
	let decision = confirm("Có phải bạn muốn xóa");
	if (!decision){
		event.preventDefault();
	}
}

$(document).ready(()=> {
	$.validator.addMethod("pattern", (value, element, pattern)=> {
        return pattern.test(value);
	});
	
	$("#createCustomer").validate({
	    rules : {
	        name : {
	            required : true
	        }, 
	        address : {
	        	required : true
	        },
	        phone : {
	        	required : true,
	        	pattern : /^((090)|(091)|(\(84\)\+90)|(\(84\)\+91))[0-9]{7}$/
	        },
	        email : {
	        	required : true
	        }
	    },
	    messages : {
	    	name : {
	            required : "Tên là bắt buộc"
	        }, 
	        address : {
	        	required : "Địa chỉ là bắt buộc"
	        },
	        phone : {
	        	required : "Số điện thoại là bắt buộc",
	        	pattern : "Số điện thoại không đúng định dạng"
	        },
	        email : {
	        	required : "Email là bắt buộc"
	        }
	    },
	    submitHandler: function(form) {
	        return true;
	    }
	});
	
	$("#createMachine").validate({
	    rules : {
	        status : {
	            required : true
	        }, 
	        position : {
	        	required : true
	        }
	    },
	    messages : {
	    	status : {
	            required : "Trạng thái là bắt buộc"
	        }, 
	        position : {
	        	required : "Vị trí là bắt buộc"
	        }
	    },
	    submitHandler: function(form) {
	        return true;
	    }
	});
	
	$("#createService").validate({
	    rules : {
	        name : {
	            required : true
	        }, 
	        unit : {
	        	required : true
	        },
	        price : {
	        	required : true,
	        	pattern : /^[1-9][0-9]*$/
	        }
	    },
	    messages : {
	    	name : {
	            required : "Tên là bắt buộc"
	        }, 
	        unit : {
	        	required : "Đơn vị tính là bắt buộc"
	        },
	        price : {
	        	required : "Đơn giá là bắt buộc",
	        	pattern : "Đơn giá phải là số nguyên dương"
	        }
	    },
	    submitHandler: function(form) {
	        return true;
	    }
	});
	
	$("#dkSuDungMay").validate({
	    rules : {
	        ngayBatDauSuDung : {
	            required : true
	        }, 
	        gioBatDauSuDung : {
	        	required : true
	        },
	        thoiGianSuDung : {
	        	required : true,
	        	pattern : /^[1-9][0-9]*$/
	        }
	    },
	    messages : {
	    	ngayBatDauSuDung : {
	            required : "Ngày bắt đầu sử dụng là bắt buộc"
	        }, 
	        gioBatDauSuDung : {
	        	required : "Giờ bắt đầu sử dụng là bắt buộc"
	        },
	        thoiGianSuDung : {
	        	required : "Thời gian sử dụng là bắt buộc",
	        	pattern : "Thời gian sử dụng phải là số nguyên dương"
	        }
	    },
	    submitHandler: function(form) {
	        return true;
	    }
	});
	
	$("#dkSuDungDV").validate({
	    rules : {
	        ngaySuDung : {
	            required : true
	        }, 
	        gioSuDung : {
	        	required : true
	        },
	        soLuong : {
	        	required : true,
	        	pattern : /^[1-9][0-9]*$/
	        }
	    },
	    messages : {
	    	ngaySuDung : {
	            required : "Ngày sử dụng là bắt buộc"
	        }, 
	        gioSuDung : {
	        	required : "Giờ sử dụng là bắt buộc"
	        },
	        soLuong : {
	        	required : "Số lượng là bắt buộc",
	        	pattern : "Số lượng phải là số nguyên dương"
	        }
	    },
	    submitHandler: function(form) {
	        return true;
	    }
	});
});